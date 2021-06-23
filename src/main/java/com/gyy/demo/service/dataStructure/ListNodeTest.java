package com.gyy.demo.service.dataStructure;

public class ListNodeTest {

    class ListNode {

        int val;
        ListNode next;
    }

    void traverse(ListNode head){
        for (ListNode p = head; p!= null;p = p.next){

        }
    }

    void traverse2(ListNode head){
        traverse2(head.next);
    }

}