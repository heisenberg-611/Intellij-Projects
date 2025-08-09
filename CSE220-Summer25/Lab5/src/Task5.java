public class Task5 {

    // Task 5A: Return max value in a linked list recursively
    public static int findMax_recursive(Node head) {
        if (head == null) return Integer.MIN_VALUE;
        int maxRest = findMax_recursive(head.next);
        return Math.max(head.elem, maxRest);
    }

    // Task 5B: Sort a linked list recursively using selection sort logic
    public static Node sortLL_recursive(Node head) {
        if (head == null || head.next == null) return head;
        // Find min node in the remaining list (including head)
        Node minNode = findMinNode(head);
        // Swap values between head and minNode
        int tmp = head.elem;
        head.elem = minNode.elem;
        minNode.elem = tmp;
        // Recurse for the remaining list
        head.next = sortLL_recursive(head.next);
        return head;
    }

    private static Node findMinNode(Node head) {
        if (head == null || head.next == null) return head;
        Node minRest = findMinNode(head.next);
        return (minRest != null && minRest.elem < head.elem) ? minRest : head;
    }

    // Task 5C: Find and print duplicate values with their positions
    public static void findDup_Recursive(Node head) {
        findDup_Helper(head, head, 0);
    }

    private static void findDup_Helper(Node originalHead, Node current, int idx) {
        if (current == null) return;
        String indices = collectIndices(originalHead, current.elem, idx, 0);
        if (indices.isEmpty()) {
            System.out.println(current.elem + ": No Duplicate");
        } else {
            System.out.println(current.elem + ": " + indices);
        }
        findDup_Helper(originalHead, current.next, idx + 1);
    }

    private static String collectIndices(Node node, int value, int excludeIndex, int currentIndex) {
        if (node == null) return "";
        String rest = collectIndices(node.next, value, excludeIndex, currentIndex + 1);
        if (currentIndex != excludeIndex && node.elem == value) {
            if (rest.isEmpty()) return String.valueOf(currentIndex);
            else return currentIndex + ", " + rest;
        }
        return rest;
    }

    public static void main(String[] args) {
        // Driver code for testing Task 5 methods        
        Node head = arr2LL( new int[]{23,5,3,11,27,6} );
        System.out.println("\n Task5A: findMax_Recursive ");
        System.out.println("The LinkedList: ");
        showLL(head);
        System.out.println("Expected Output: "+27);
        System.out.println("Your Output: "+findMax_recursive(head));

        System.out.println("\n------------------------------");

        System.out.println("\n Task5B: sortLL_Recursive ");
        System.out.println("The LinkedList: ");
        showLL(head);
        System.out.println("Expected Output:");
        System.out.println("3 -> 5 -> 6 -> 11 -> 23 -> 27 -> null");
        System.out.println("Your Output: ");
        Node sortedHead = sortLL_recursive(head);
        showLL(sortedHead);
        
        System.out.println("\n------------------------------");

        System.out.println("\n Task5C: findDup_Recursive ");
        head = arr2LL(new int[]{ 10, 22, 13, 20, 22, 23, 10, 22 });
        System.out.println("The LinkedList: ");
        showLL(head);
        System.out.println("Expected Output: ");
        System.out.println("10: 6\n22: 4, 7\n13: No Duplicate\n20: No Duplicate\n22: 1, 7\n23: No Duplicate\n10: 0\n22: 1, 4\n");
        System.out.println("Your Output: ");
        findDup_Recursive(head);

    }

    // Helper method to show the list (for driver code)
    public static void showLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.elem + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static Node arr2LL(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node n = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            n.next = newNode;
            n = newNode;
        }
        return head;
    }
}
