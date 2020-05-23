package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * <p>
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class _25_CloneLinkList {
    /**
     * 思路1：
     * 暴力法
     * 1、考虑特殊情况
     * -A：pHead==null
     * 2、先将单链表进行简单p-p.next复制，
     * 3、在复制random节点，每次复制random节点都必须从head开始从头遍历节点.时间复杂度 O(n2)
     * <p>
     * 思路2：
     * 使用map存储，由空间复杂度换时间复杂阿杜
     * 1、考虑特殊情况
     * -A:pHead=null，return
     * 2、先构建简单的单链表，并使用Map存储 node与cloneNode
     * 3、同时遍历单链表原来的单链表和复制的链表，使用map获取cloneNode的random节点
     * <p>
     * 思路3：
     * //todo
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> nodesMap = new HashMap<>();
        RandomListNode sourcePointer = pHead;
        RandomListNode targetHead = new RandomListNode(sourcePointer.label);
        nodesMap.put(pHead, targetHead);
        RandomListNode targetTail = targetHead;
        // 构建简单链表
        do {
            sourcePointer = sourcePointer.next;
            if(sourcePointer==null){
                break;
            }
            targetTail.next =
                    new RandomListNode(sourcePointer.label);
            targetTail = targetTail.next;
            //将圆节点与克隆节点放到map中
            nodesMap.put(sourcePointer, targetTail);
        } while (sourcePointer.next != null);

        sourcePointer = pHead;
        RandomListNode targetPointer = targetHead;
        //构建复杂链表的random节点
        while (sourcePointer != null) {
            targetPointer.random = nodesMap.get(sourcePointer.random);
            sourcePointer = sourcePointer.next;
            targetPointer = targetPointer.next;
        }
        return targetHead;
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);

        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        r1.next = r2;
        r1.random = r3;
        r2.next = r3;
        r2.random = r4;
        r3.next = r4;
        r3.random = r1;
        r4.next = null;
        r4.random = r1;

        _25_CloneLinkList cloneLinkList = new _25_CloneLinkList();
        RandomListNode clone = cloneLinkList.Clone(r1);
        System.out.println(clone);
        while (clone.next != null) {
            System.out.println(clone.label + " " + clone.next.label + " " + clone.random.label);
            clone = clone.next;
        }

    }
}

