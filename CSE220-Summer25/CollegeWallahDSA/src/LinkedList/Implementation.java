package LinkedList;

public class Implementation {

    public static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public static class linkedList{
        Node head = null;
        Node tail = null;
        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        void insertAtHead(int data) {
            Node newNode = new Node(data);
//            if (head == null) { //empty list
//                head = newNode;
//                tail = newNode;
            if (head == null) { //same works
                insertAtEnd(data);
            } else { //non-empty list
                newNode.next = head;
                head = newNode;
            }
        }
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        int size() {
            int size = 0;
            Node temp = head;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
            return size;
        }
        void insertAt(int index, int data) {
            Node x = new Node(data);
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            x.next = temp.next;
            temp.next = x;
        }
    }
    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertAtHead(1);
        ll.insertAtEnd(4);
        ll.display();
        ll.insertAtEnd(5);
        ll.display();
//        System.out.println(ll.size());
        ll.insertAtEnd(6);
        ll.display();
        System.out.println(ll.size());
        ll.insertAtHead(7);
        ll.display();
        System.out.println(ll.size());
        ll.insertAt(1,8);
        ll.display();
    }
}