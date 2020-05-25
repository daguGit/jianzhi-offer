package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.ListNode;

/**
 * 两个链表的第一个公共结点
 * <p>
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class _36_FindFirstCommonNode {
    /**
     * 思路:
     * 1、特殊情况
     * -A:pHead1==null||pHead2=null return null
     * 2、使用快慢指针
     * -A、声明 p1=pHead1，p2=pHead2
     * -B、记录pHead1的长度 l1、记录pHead2的长度 l2
     * -C、比较 n=Math.abs(l1,l2)
     * -D、另快指针先走n步，后快慢指针同步走，直到指针相同
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //获取长度
        int l1 = 0;
        int l2 = 0;
        while (p1 != null) {
            l1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            l2++;
            p2 = p2.next;
        }
        int distance = Math.abs(l1 - l2);
        ListNode fast = null;
        ListNode slow = null;
        if (l1 >= l2) {
            fast = pHead1;
            slow = pHead2;
        } else {
            fast = pHead2;
            slow = pHead1;
        }
        //fast 指针先走
        while (distance > 0) {
            fast = fast.next;
            distance--;
        }
        //两个指针同步走
        while (fast != null && slow != null) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
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
//        listNode6.next = listNode4;
        _36_FindFirstCommonNode findFirstCommonNode = new _36_FindFirstCommonNode();
        ListNode listNode = findFirstCommonNode.FindFirstCommonNode(listNode1, listNode6);
        System.out.println(listNode.val);
    }
}
