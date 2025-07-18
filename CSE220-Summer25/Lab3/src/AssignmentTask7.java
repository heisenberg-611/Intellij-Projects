public class AssignmentTask7 {

    //SUBMIT ONLY THIS METHOD
    public static void rangeMove(DNode dh, int start, int end) {
        if (dh == null || dh.next == dh) {
            return;
        }
        DNode current = dh.next;
        DNode tail = dh.prev;
        DNode lol = dh.prev;
        while (current != dh) {
            DNode next = current.next;
            if ((int) current.elem >= start && (int) current.elem <= end) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                tail.next = current;
                current.prev = tail;
                current.next = dh;
                dh.prev = current;
                tail = current;
            }
            if (current == lol) {
                break;
            }
            current = next;
        }
    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] values = {5, 3, 7, 1, 9, 6, 2, 4};
        DNode dh = LinkedListHelpers.createDummyHeadedDoublyLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);

        System.out.println("\nExpected Output:");
        Object[] expected = {3, 1, 9, 2, 4, 5, 7, 6};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);

        //Running the Range Move with [5,7] ranges
        rangeMove(dh, 5, 7);
        //Printing after Range Move
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);
    }
}
