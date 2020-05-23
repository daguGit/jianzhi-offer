package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

/**
 * 二叉搜索树与双向链表
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class _26_Convert2LinkList {
    //定义链表当前结点
    TreeNode pointer = null;
    //定义链表头部的结点
    TreeNode head = null;

    /**
     * 思路：
     * 直接使用中序遍历即可实现，不需要考虑具体在树中各种情况下指针变化，只需考虑链表头尾节点指针变化即可
     *
     * @param pRootOfTree
     * @return
     */
    //中序递归遍历修改链表指针即可实现
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        //左
        Convert(pRootOfTree.left);
        //根
        if (pointer == null) {
            pointer = pRootOfTree;
            head = pRootOfTree;
        } else {
            pointer.right = pRootOfTree;
            pRootOfTree.left = pointer;
            pointer = pRootOfTree;
        }
        //右
        Convert(pRootOfTree.right);
        return head;
    }

    public static void main(String[] args) {

    }
}
