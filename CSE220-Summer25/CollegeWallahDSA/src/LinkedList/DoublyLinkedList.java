package LinkedList;

public class DoublyLinkedList {

//    public static class Node{
//        Node next;
//        int val;
//        Node prev;
//        Node(int x){
//            val = x;
//        }
//    }
    public static void display(Node head){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void displayrev(Node tail){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void displayRandom(Node random){
        Node temp = random;
        // Move this temp backwards to the head
        while(temp.prev != null){
            temp = temp.prev;
        }
        //now temp is at head
        //print the list
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //4 10 2 99 13
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);
        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;
        e.next = null;
        DLL.InsertAtTail(a, 2);
        display(a);
//        displayrev(e);
//        displayRandom(c);
//        Node newHead = DLL.InsertAtHead(a,35);
//        display(newHead);

    }
}
