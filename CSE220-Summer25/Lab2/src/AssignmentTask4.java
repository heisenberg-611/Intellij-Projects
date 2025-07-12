// AssignmentTask4: ID Generator
public class AssignmentTask4{

    // Must Submit this method
    // After you're done coding submit only this method
    public static Node idGenerator(Node head1, Node head2, Node head3) {
        // Step 1: Reverse the first linked list (head1)
        Node temp1 = head1;
        Node prev = null;
        Node tail = null;

        // Store the first node as tail (will be the last after reversal)
        if (temp1 != null) {
            tail = temp1;
        }

        // Reverse the first linked list
        while (temp1 != null) {
            Node next = temp1.next;  // store next node
            temp1.next = prev;      // reverse the link
            prev = temp1;           // move prev to current node
            temp1 = next;           // move to the next node
        }

        // Update head1 to point to the reversed list
        Node reversedHead = prev;

        // Step 2: Create a new linked list by adding corresponding elements from head2 and head3
        Node temp2 = head2;
        Node temp3 = head3;
        Node resultTail = tail;  // Start with the tail of the reversed list

        // Ensure tail's next is null
        if (resultTail != null) {
            resultTail.next = null;
        }

        // Add corresponding elements from head2 and head3
        while (temp2 != null && temp3 != null) {
            int sum = (int)temp2.elem + (int)temp3.elem;
            Node newNode = new Node(sum % 10);  // Take modulo 10 to handle carry

            // Append the new node to the result list
            if (resultTail == null) {
                // If resultTail is null, this is the first node in the result
                resultTail = newNode;
                // If reversedHead is null, set it to the first node
                reversedHead = newNode;
            } else {
                resultTail.next = newNode;
                resultTail = newNode;
            }

            temp2 = temp2.next;
            temp3 = temp3.next;
        }

        return reversedHead;
    }

    //NOTE: if you find any issue with the driver code, please inform AIB
    //DO NOT MAKE ANY MODIFICATIONS IN THE TESTER CODE BELOW
    public static void main(String[] args) {
        System.out.println("=========Test Case 1=============");
        Node head1 = LinkedList.createList(new Integer[]{0, 3, 2, 2});
        Node head2 = LinkedList.createList(new Integer[]{5, 2, 2, 1});
        Node head3 = LinkedList.createList(new Integer[]{4, 3, 2, 1});

        System.out.print("LinkedList#1:  ");
        LinkedList.printLL(head1); // This should print 0 -> 3 -> 2 -> 2

        System.out.print("LinkedList#2:  ");
        LinkedList.printLL(head2); // This should print 5 -> 2 -> 2 -> 1

        System.out.print("LinkedList#3:  ");
        LinkedList.printLL(head3); // This should print 4 -> 3 -> 2 -> 1

        Node result = idGenerator(head1, head2, head3);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result); // This should print 2 -> 2 -> 3 -> 0 -> 9 -> 5 -> 4 -> 2

        System.out.println("\n=========Test Case 2=============");
        Node head4 = LinkedList.createList(new Integer[]{0, 3, 9, 1});
        Node head5 = LinkedList.createList(new Integer[]{3, 6, 5, 7});
        Node head6 = LinkedList.createList(new Integer[]{2, 4, 3, 8});

        System.out.print("LinkedList#4:  ");
        LinkedList.printLL(head4); // This should print 0 -> 3 -> 9 -> 1

        System.out.print("LinkedList#5:  ");
        LinkedList.printLL(head5); // This should print 3 -> 6 -> 5 -> 7

        System.out.print("LinkedList#6:  ");
        LinkedList.printLL(head6); // This should print 2 -> 4 -> 3 -> 8

        Node result2 = idGenerator(head4, head5, head6);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result2); // This should print 1 -> 9 -> 3 -> 0 -> 5 -> 0 -> 8 -> 5
    }
}
