package com.learn.java;

public class ReverseListClass {
    public static void main(String[] arg) {

        ListNode temp1 = new ListNode(1);
        ListNode temp2 = new ListNode(2);
        ListNode temp3 = new ListNode(3);
        ListNode temp4 = new ListNode(4);
        ListNode temp5 = new ListNode(5);
        ListNode temp6 = null;
        temp1.setNext(temp2);
        temp2.setNext(temp3);
        temp3.setNext(temp4);
        temp4.setNext(temp5);
        temp5.setNext(temp6);
        System.out.println("1值="+temp1.val);
        System.out.println("2值="+temp1.getNext().val);
        System.out.println("3值="+temp1.getNext().getNext().val);
        System.out.println("4值="+temp1.getNext().getNext().getNext().val);
        System.out.println("5值="+temp1.getNext().getNext().getNext().getNext().val);
        System.out.println("6值="+(null==temp1.getNext().getNext().getNext().getNext().getNext()?"null":temp1.getNext().getNext().getNext().getNext().getNext().getVal()));

        ListNode result = reverseList(temp1);

        System.out.println("1值="+result.val);
        System.out.println("2值="+result.getNext().val);
        System.out.println("3值="+result.getNext().getNext().val);
        System.out.println("4值="+result.getNext().getNext().getNext().val);
        System.out.println("5值="+result.getNext().getNext().getNext().getNext().val);
        System.out.println("6值="+(null==result.getNext().getNext().getNext().getNext().getNext()?"null":temp1.getNext().getNext().getNext().getNext().getNext().getVal()));


    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {  //head.next==null，所以head = 5
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;   //cur = 5，在if里已经走了，递归向下走，只能是4
        head.next = null;
        return p;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
}
