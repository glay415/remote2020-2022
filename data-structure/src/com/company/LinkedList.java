package com.company;

public class LinkedList {
    public Node head;
    private Node tail;
    private int size = 0;
    private class Node{
        public Object data;
        public Node next;
        public Node(Object input){
            this.data = input;
            this.next = null;
        }
    }
}
