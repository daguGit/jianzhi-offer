package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class _38_TreeDepth {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
        }
    }



    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(2);
//        TreeNode treeNode5 = new TreeNode(4);
        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(8);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;


        _38_TreeDepth dept = new _38_TreeDepth();
        int i = dept.TreeDepth(treeNode1);
        System.out.println(i);

    }
}
