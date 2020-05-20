package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.ListNode;

/**
 * 反转链表
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class _15_ReverseList {
    /**
     * 思路：
     * 1、使用头插法
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null ;

        if(head == null) {
            return newHead;
        }

        newHead = new ListNode(head.val);
        ListNode nextNode = head.next;
        while(nextNode!=null){
            ListNode newNode = new ListNode(nextNode.val);
            newNode.next = newHead;
            newHead = newNode;

            nextNode = nextNode.next;

        }
        return newHead;
    }
}
