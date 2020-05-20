package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.ListNode;

/**
 * 合并两个排序的链表
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class _16_MergeLinkNode {
    /**
     * 思路：
     * 1、特殊情况
     * -A：list1==list2==null return null；
     * -B：list1==null&&list2!=null return list2
     * -C：list1!=null&&list2==null return list1
     * 2、声明head p = list1，q = list2，p q比较添加到head后面，直到 p=null && q=null
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list1 == null) {
            return null;
        }
        if(list1!=null&&list2==null){
            return list1;
        }
        if(list1==null&&list2!=null){
            return  list2;
        }

        ListNode head = null,tail = null,temp,p=list1,q=list2;

        while(p!=null&&q!=null){
            if(p.val<=q.val){
                temp =p ;
                p=p.next;
            }else {
                temp = q;
                q= q.next;
            }
            // 封装头结点
            if(head==null){
                head = temp;
                tail = temp;
            }else{
                //添加尾结点
                tail.next = temp;
                tail = tail.next;
            }
        }
        //如果 p没有遍历完，添加在尾部
        if(p!=null){
            tail.next = p;
        }
        //如果q没有遍历完，添加在尾部
        if(q!=null){
            tail.next = q;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(5);
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(2);
//        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(6);
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(7);
        listNode6.next = listNode7;
        ListNode listNode8 = new ListNode(8);
        listNode7.next = listNode8;

        _16_MergeLinkNode mergeLinkNode = new _16_MergeLinkNode();
        ListNode merge = mergeLinkNode.Merge(listNode1, listNode4);
        while(true){
            System.out.println(merge.val);
            merge=merge.next;
            if(merge==null){
                return;
            }
        }
    }
}
