package com.github.dagugit.algorithm.common;

/**
 * @author Administrator
 */
public class ListNode {
    // 这里为了在其他包中调用，将属性写成public，无特殊含义，其他同理
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
