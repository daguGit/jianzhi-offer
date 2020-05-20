package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.ListNode;

/**
 * 链表中倒数第k个结点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class _14_FindKthToTail {
    /**
     * 思路：
     * 1、特殊情况
     * -A：head为空，return null
     * -B：k<=0,return null;
     * 2、使用快慢指针，同步
     * -A：fast走k步、k--，当 fast==null&&k>0时，证明k>list.length 返回null
     * -B: fast、slow同步，当fast到末尾时，返回slow
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
            //当k>链表长度时，return null;
            if (k > 0 && fast == null) {
                return null;
            }
        }
        //fast and slow 同步
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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

        _14_FindKthToTail findKthToTail = new _14_FindKthToTail();
        ListNode listNode00 = findKthToTail.FindKthToTail(listNode1, 0);
        ListNode listNode01 = findKthToTail.FindKthToTail(listNode1, 1);
        ListNode listNode03 = findKthToTail.FindKthToTail(listNode1, 3);
        ListNode listNode05 = findKthToTail.FindKthToTail(listNode1, 5);
        ListNode listNode07 = findKthToTail.FindKthToTail(listNode1, 4);
        ListNode listNode09 = findKthToTail.FindKthToTail(listNode1, 9);
    }
}
