public class test {
        public static Node rmGivenAllNode(Node head, Integer target) {
            // First remove ALL leading target nodes
            while (head != null && head.elem.equals(target)) {
                head = head.next;
            }

            // If list became empty after removal
            if (head == null) {
                return null;
            }

            // Now process the rest of the list
            Node current = head;
            while (current != null && current.next != null) {
                if (current.next.elem.equals(target)) {
                    // Skip the target node
                    current.next = current.next.next;
                } else {
                    // Move forward
                    current = current.next;
                }
            }
            return head;
        }
        public static void main(String[] args) {
            Node head = LinkedList.createList(new Object[]{7, 1, 7, 7});
            System.out.println("Original List: ");
            LinkedList.printLL(head);
            head = rmGivenAllNode(head, 7);
            System.out.println("List after removing all nodes having value 7: ");
            LinkedList.printLL(head);
        }
    }
