package com.java.common;

public class MyLinkList {

    public static class Node {
        int val;
        Node next;
        Node(int _val) {
            val = _val;
        }

        public String printList() {
            StringBuilder sb = new StringBuilder();
            Node temp = new Node(val);
            temp.next = next;
            while(temp != null) {
                sb.append(String.format("[%d]", temp.val) + " -> ");
                temp = temp.next;
            }
            sb.append("[null]");

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node current = head;
        for(int i = 2; i<6; i++) {
            Node temp = new Node(i);
            current.next = temp;
            current = temp;
        }

        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = slow.next;
        Node first = head;
        slow.next = null;

        while(second != null ) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

        // head = prev;


        System.out.println(head.printList());
        // System.out.println(current.printList());
    }
}
