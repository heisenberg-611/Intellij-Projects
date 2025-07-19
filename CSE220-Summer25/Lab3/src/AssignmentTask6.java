public class AssignmentTask6 {

    //SUBMIT ONLY THIS METHOD
    public static void pairJoin(DNode dh1, DNode dh2) {
        if (dh1 == null || dh2 == null) return;
        DNode kataMatha1 = dh1.next; DNode KataMatha2 = dh2.next;
        DNode lej = dh1; DNode curr = dh1;
        while (kataMatha1 != null && KataMatha2 != null) {
            DNode next1 = kataMatha1.next;
            DNode next2 = KataMatha2.next;
            curr.next = kataMatha1;
            kataMatha1.prev = curr;
            curr = kataMatha1;
            curr.next = KataMatha2;
            KataMatha2.prev = curr;
            curr = KataMatha2;
            kataMatha1 = next1;
            KataMatha2 = next2;
            lej = curr;
        }
        while (kataMatha1 != null) {
            DNode next1 = kataMatha1.next;
            curr.next = kataMatha1;
            kataMatha1.prev = curr;
            curr = kataMatha1;
            kataMatha1 = next1;lej = curr;}
        while (KataMatha2 != null) {
            DNode next2 = KataMatha2.next;
            curr.next = KataMatha2;
            KataMatha2.prev = curr;
            curr = KataMatha2;
            KataMatha2 = next2;
            lej = curr;}
        lej.next = dh1;
        dh1.prev = lej;
    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] list1 = {"A", "B", "C", "D"};
        Object[] list2 = {"E", "F", "G", "H"};

        DNode dh1 = LinkedListHelpers.createDummyHeadedDoublyLL(list1, false);
        DNode dh2 = LinkedListHelpers.createDummyHeadedDoublyLL(list2, false);

        System.out.println("Given Linked List 1:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh1);

        System.out.println("Given Linked List 2:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh2);

        System.out.println("\nExpected Output:");
        Object[] expected = {"A", "E", "B", "F", "C", "G", "D", "H"};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);

        //Running the Pair Join
        pairJoin(dh1, dh2);
        //Printing after Pair Join
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh1);
    }
}
//public static void pairJoin(DNode dh1, DNode dh2) {
//    // Skip the dummy head of both lists to start with actual elements
//    DNode curr1 = dh1.next;  // First actual node of list 1
//    DNode curr2 = dh2.next;  // First actual node of list 2
//
//    // Keep track of the last node to make the list circular at the end
//    DNode tail = dh1;
//
//    // Start from the dummy head of the first list
//    DNode current = dh1;
//
//    // Continue until we reach the end of either list
//    while (curr1 != null && curr2 != null) {
//        // Connect current to node from list 1
//        current.next = curr1;
//        curr1.prev = current;
//        current = curr1;
//
//        // Save next nodes before changing pointers
//        DNode next1 = curr1.next;
//
//        // Connect current to node from list 2
//        current.next = curr2;
//        curr2.prev = current;
//        current = curr2;
//
//        // Save next node from list 2 before changing pointers
//        DNode next2 = curr2.next;
//
//        // Update pointers for the next iteration
//        curr1 = next1;
//        curr2 = next2;
//
//        // Update tail to the last processed node
//        tail = current;
//    }
//
//    // If list 1 has remaining nodes, connect them
//    while (curr1 != null) {
//        current.next = curr1;
//        curr1.prev = current;
//        current = curr1;
//        curr1 = curr1.next;
//        tail = current;
//    }
//
//    // If list 2 has remaining nodes, connect them
//    while (curr2 != null) {
//        current.next = curr2;
//        curr2.prev = current;
//        current = curr2;
//        curr2 = curr2.next;
//        tail = current;
//    }
//
//    // Make the list circular by connecting the last node to the dummy head
//    // and the dummy head's prev to the last node
//    tail.next = dh1;
//    dh1.prev = tail;
//}