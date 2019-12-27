package com.java.common;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()) {
            System.exit(0);
        }
        int pop = stack2.pop();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return pop;
    }

    /** Get the front element. */
    public int peek() {
        while(!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        if(stack2.isEmpty()) {
            System.exit(0);
        }
        int peek = stack2.peek();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());  // returns 1
        System.out.println(queue.pop());  // returns 1
        System.out.println(queue.pop());  // returns 1
        System.out.println(queue.pop());  // returns 1
        System.out.println(queue.empty());  // returns 1




    }
}