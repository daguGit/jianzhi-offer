package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 从上往下打印二叉树
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class _22_PrintFromTopToBottom {
    /**
     * 思路：
     * 1、直接使用deque遍历即可
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }

        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            list.add(pop.val);

            if (pop.left != null) {
                deque.add(pop.left);
            }
            if (pop.right != null) {
                deque.add(pop.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        treeNode5.left = treeNode10;
        treeNode5.right = treeNode11;
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode13 = new TreeNode(13);
        treeNode6.left = treeNode12;
        treeNode6.right = treeNode13;
        TreeNode treeNode14 = new TreeNode(14);
        TreeNode treeNode15 = new TreeNode(15);
        treeNode7.left = treeNode14;
        treeNode7.right = treeNode15;
        _22_PrintFromTopToBottom printFromTopToBottom = new _22_PrintFromTopToBottom();
        ArrayList<Integer> integers = printFromTopToBottom.PrintFromTopToBottom(treeNode1);
        integers.stream().forEach(a->{
            System.out.println(a);
        });
    }
}
