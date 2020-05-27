package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.ListNode;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 * <p>
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class _03_PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> record = new ArrayList<Integer>();
        while (listNode != null) {
            record.add(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> returnValue = new ArrayList<>();
        for (int i = record.size() - 1; i >= 0; i--) {
            returnValue.add(record.get(i));
        }
       //Collections.reverse(returnValue);
        return returnValue;
    }

    /**
     * 思路：
     * 1、使用头插法
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHeadII(ListNode listNode){
        ArrayList<Integer> record = new ArrayList<Integer>();
        while (listNode != null) {
            record.add(0,listNode.val);
            listNode = listNode.next;
        }
        return record;
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(6);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(7);
        listNode6.next = listNode7;
        ListNode listNode8 = new ListNode(8);
        listNode7.next = listNode8;
        ListNode listNode9 = new ListNode(9);
        listNode8.next = listNode9;

        _03_PrintListFromTailToHead printListFromTailToHead = new _03_PrintListFromTailToHead();
        ArrayList<Integer> integers = printListFromTailToHead.printListFromTailToHead(listNode1);
        for (Integer a : integers) {
            System.out.println(a);
        }
    }
}
