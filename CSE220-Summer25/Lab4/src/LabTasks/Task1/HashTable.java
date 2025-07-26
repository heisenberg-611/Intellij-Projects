package LabTasks.Task1;

/*You will have to complete the FruitNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and insert()
 the rest of the methods are already written
 DO NOT TOUCH any other methods or codes*/
public class HashTable {

    //ht[] :: is the HashTable array that stores the FruitNode objects
    private FruitNode[] ht;

    //Constructor that initializes the HashTable array
	//DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new FruitNode[size];
    }
    
    //This method basically prints the HashTable
    //DO NOT change this method
    public void show(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" " );
            FruitNode n = ht[i];
            while (n!=null){
                System.out.print("('"+n.fruit[0]+"', "+n.fruit[1]+") --> ");
                n = n.next;
            }
            System.out.println();
        }
    }

    //you need to COMPLETE this method
    private int hashFunction( String key ){
        // TO DO
        int len = key.length();

        if(len%2==0){
            int sum = 0;
            for(int i=0; i<len; i+=2){
                sum += key.charAt(i);
            }
            return sum%ht.length;
        } else {
            int sum = 0;
            for (int i = 1; i < len; i += 2) {
                sum += key.charAt(i);
            }
            return sum%ht.length;
        }
    }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
	//then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value) {
        int index = hashFunction(key);  // You must define this function
        FruitNode head = ht[index];  // table[] is your hash table array

        // Step 1: Check if the key already exists and update
        FruitNode current = head;
        while (current != null) {
            if (current.fruit[0].equals(key)) {
                current.fruit[1] = value;
                ht[index] = sortDescending(ht[index]); // sort after update
                return;
            }
            current = current.next;
        }

        // Step 2: Create new node
        FruitNode newNode = new FruitNode(key, value);

        // Step 3: No collision
        if (head == null) {
            ht[index] = newNode;
            return;
        }

        // Step 4: Collision — insert in descending order of price
        Integer headPrice = (Integer) head.fruit[1];
        if (value > headPrice) {
            newNode.next = head;
            ht[index] = newNode;
        } else {
            FruitNode temp = head;
            while (temp.next != null && (Integer) temp.next.fruit[1] >= value) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    private FruitNode sortDescending(FruitNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Convert chain to a list of FruitNodes
        java.util.List<FruitNode> nodeList = new java.util.ArrayList<>();
        while (head != null) {
            String name = (String) head.fruit[0];
            Integer price = (Integer) head.fruit[1];
            nodeList.add(new FruitNode(name, price));
            head = head.next;
        }

        // Step 2: Sort list by descending price
        nodeList.sort((a, b) -> ((Integer) b.fruit[1]) - ((Integer) a.fruit[1]));

        // Step 3: Rebuild linked list from sorted nodes
        FruitNode dummy = new FruitNode(null, 0);
        FruitNode tail = dummy;
        for (FruitNode node : nodeList) {
            tail.next = node;
            tail = node;
        }
        tail.next = null;

        return dummy.next;
    }
}
