package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
public class _39_IsBalanced {
    /**
     * 1、特殊情况
     * -A：root==null return true
     * 2、判断 Math.abs(root.left.dept-root.right.dept)<=1
     *   && root.left 为平衡二叉树
     *   && root.right 为平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean IsBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return (Math.abs(this.getDepth(root.right) - this.getDepth(root.left)) <= 1)
                && IsBalanced(root.left)
                && IsBalanced(root.right);
    }

    /***
     * 获取树的高度
     *
     * @param root
     * @return
     */
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }
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
        _39_IsBalanced isBalanced = new _39_IsBalanced();
        boolean b = isBalanced.IsBalanced(treeNode1);
        System.out.println(b);

    }
}
