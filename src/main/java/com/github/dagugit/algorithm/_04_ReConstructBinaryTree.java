package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.Arrays;

/**
 * 重建二叉树
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author Administrator
 */
public class _04_ReConstructBinaryTree {
    /**
     * 思路：
     * 使用递归的思路
     * 1、前序遍历的首节点为树的根节点
     * 2、在中序遍历中找到此节点，将中序遍历分成两部分，左半部分递归构成根节点的左子树，右半部分递归构成根节点的右子树
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //当前序遍历为空时终止递归
        if (pre.length == 0) {
            return null;
        }
        int start = pre[0];
        //构建根节点
        TreeNode root = new TreeNode(start);
        int startPos = this.findPos(in, start);
        //构建左子树的前序遍历
        int[] in2 = Arrays.copyOfRange(in, 0, startPos);
        //构建左子树
        TreeNode left = this.reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + in2.length), in2);
        //构建右子树
        TreeNode right = this.reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + in2.length, pre.length), Arrays.copyOfRange(in, startPos + 1, in.length));
        root.left = left;
        root.right = right;
        return root;
    }

    /**
     * 在 in 中找到start的位置
     *
     * @param in
     * @param start
     * @return
     */
    private int findPos(int[] in, int start) {
        for (int i = 0; i < in.length; i++) {
            if (start == in[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        _04_ReConstructBinaryTree reConstructBinaryTree = new _04_ReConstructBinaryTree();
        TreeNode treeNode = reConstructBinaryTree.reConstructBinaryTree(pre, in);
        System.out.println();
    }

}

