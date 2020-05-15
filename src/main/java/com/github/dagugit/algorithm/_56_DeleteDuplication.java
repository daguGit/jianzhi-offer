package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除链表中重复的结点
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class _56_DeleteDuplication {
    /**
     * 思路
     * 1:当 pHead == null,返回null
     * 2：使用map记录链表值分别个数
     * --A:声明p，找到第一个个数不大于1的节点
     * --B：没有找p直接返回
     * --C:构建链表
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
        ListNode p = pHead;
        while (p != null) {
            record.put(p.val, record.get(p.val) == null ? 1 : record.get(p.val) + 1);
            p = p.next;
        }

        //找到第一个个数为1的节点
        p = pHead;
        while (true) {
            if (p != null && record.get(p.val) > 1) {
                p = p.next;
            } else {
                break;
            }
        }
        //若没有找到一个个数为1的节点，直接返回
        if (p == null) {
            return null;
        }
        //q记录头结点，t记录尾节点，构建链表
        ListNode q = null, t = null;
        while (true) {
            if (p == null) {
                break;
            } else {
                //构建头结点
                if (q == null && record.get(p.val) == 1) {
                    t = new ListNode(p.val);
                    q = t;
                    p = p.next;
                } else if (record.get(p.val) == 1) {
                    t.next = new ListNode(p.val);
                    t = t.next;
                    p = p.next;
                } else {
                    p = p.next;
                }
            }
        }
        return q;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(3);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(4);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(5);
        listNode6.next = listNode7;
        ListNode listNode8 = new ListNode(5);
        listNode7.next = listNode8;
        _56_DeleteDuplication deleteDuplication = new _56_DeleteDuplication();
        ListNode listNode = deleteDuplication.deleteDuplication(listNode1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}

