package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.ListNode;

/**
 * 链表中环的入口结点
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class _55_EntryNodeOfLoop {
    /**
     * 思路：
     * 1：怎样判断一个链表有环
     * -A:使用快慢指针，slow、fast;slow=slow.next,fast=fast.next.next;
     * -B:当slow==fast时，证明有环
     * 2：找到链表环的入口：
     * -A:设起点为A，环起点为B，到C点相遇，则（AB+BC）*2=AB+BC+CB+BC,所以AB+BC=BC+CB，即AB=CB
     * -B:当两个点相遇后，设置p为head，随着slow走，当p==slow时，即为环的起点；
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        boolean loopList = isLoopList(pHead);
        if (!loopList == true) {
            return null;
        } else {
            ListNode slow, fast, p;
            slow = fast = p = pHead;
            while (slow != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    break;
                }
            }
            while (p != slow) {
                p = p.next;
                slow = slow.next;
            }
            return p;
        }
    }

    public boolean isLoopList(ListNode pHead) {
        ListNode slow, fast;
        slow = fast = pHead;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 同理，简化后的代码
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if (p1 == p2) return p1;
            }
        }
        return null;
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
        listNode9.next = listNode4;
        _55_EntryNodeOfLoop entryNodeOfLoop = new _55_EntryNodeOfLoop();
        boolean loopList = entryNodeOfLoop.isLoopList(listNode1);
        System.out.println(loopList);
        ListNode listNode = entryNodeOfLoop.EntryNodeOfLoop(listNode1);
        System.out.println(listNode.val);
    }
}
