package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.ArrayList;

/**
 * 二叉搜索树的第k个结点
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class _62_KthNodeInBST {
    private ArrayList<TreeNode> list = new ArrayList<TreeNode>();

    /**
     * 直接中序遍历
     *
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        proList(pRoot, list);
        if(k<=0){
            return  null;
        }
        if (k > list.size()) {
            return null;
        }
        return list.get(k - 1);
    }

    private void proList(TreeNode pRoot, ArrayList<TreeNode> list) {
        if (pRoot.left != null) {
            proList(pRoot.left, list);
        }
        list.add(pRoot);
        if (pRoot.right != null) {
            proList(pRoot.right, list);
        }
    }


    private TreeNode node;
    private int K;

    /**
     * 上述方法遍历完整颗二叉树，能够遍历K次找到第K小的数
     * 中序遍历，K 依次递减
     *
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode KthNodeII(TreeNode pRoot, int k) {
        if (k <= 0) {
            return null;
        }
        this.K = k;
        proListII(pRoot);
        return node;
    }


    private void proListII(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        if (pRoot.left != null) {
            proListII(pRoot.left);
        }
        K--;
        if (K == 0) {
            node = pRoot;
        }
        if (pRoot.right != null) {
            proListII(pRoot.right);
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(8);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        _62_KthNodeInBST kthNode = new _62_KthNodeInBST();
        TreeNode treeNode = kthNode.KthNode(treeNode1, 3);
        System.out.println(treeNode.val);
    }
}
