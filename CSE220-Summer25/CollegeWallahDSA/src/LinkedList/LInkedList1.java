package LinkedList;

//Singly Linked List

import java.util.LinkedList;

public class LInkedList1 {
    public static void displayInkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static class Node{
        int data; //value
        Node next; //address of next node
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node x = new Node(5); //head
//        System.out.println(x.next); //null
        Node y = new Node(3);
        Node z = new Node(9);
        Node w = new Node(8);
        Node q = new Node(16);
        Node r = new Node(10); //tail

        x.next = y;//5 -> 3  9  8  16
        y.next = z;//5 -> 3 -> 9  8  16
        z.next = w;//5 -> 3 -> 9 -> 8  16
        w.next = q;//5 -> 3 -> 9 -> 8 -> 16
//        q.next = x;//5 -> 3 -> 9 -> 8 -> 16 -> 5
        r.next = y;//5 -> 3 10 -> 3 -> 9 -> 8 -> 16 -> 5
        r.next = z;//5 -> 3 -> 9 (10 -> 3 ; 10 -> 9) 9 -> 8 -> 16 -> 5
        x.next = r;//5 -> 10 9 -> 8 -> 16 -> 5
        r.next = z;//5 -> 10 -> 9 -> 8 -> 16 -> 5

//        System.out.println(x); //$Node@a09ee92
//        System.out.println(x.next); //$Node@30f39991
//        System.out.println(y); //$Node@30f39991
//        System.out.println(x.next.data); //3
//        System.out.println(q.next.data); //5
//        System.out.println(x.next.next.next.data); //8
//        Node temp = x;
//        for(int i=1;i<=6;i++){
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//        while(temp != null){
//            System.out.println(temp.data + " ");
//            temp = temp.next;
//        }
        displayInkedList(x);
        //Recursive approach

    }
}