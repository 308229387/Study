package com.learn.java;

import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

public class CQueueClass {
    private static Stack<Integer> stack1;
    private static Stack<Integer> stack2;

    public CQueueClass() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public static void appendTail(int value) {
        stack1.push(value);
    }

    public static int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }

    public static void main(String[] arg) {
        new CQueueClass();
        appendTail(1);
        appendTail(2);
        appendTail(3);
        deleteHead();
        appendTail(4);
        appendTail(5);
        appendTail(6);
        deleteHead();


        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }

}