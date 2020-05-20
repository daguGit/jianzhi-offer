package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树的镜像
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class _18_BinaryTreeMirror {
    /**
     * 思路：
     * 1、特殊情况
     * -A:当root为空时，直接返回
     * 2、使用递归，将左右两个子树互换
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        buildMirrorBinaryTree(root);
    }

    private void buildMirrorBinaryTree(TreeNode root) {
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            buildMirrorBinaryTree(root.left);
        }
        if (root.right != null) {
            buildMirrorBinaryTree(root.right);
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
        _18_BinaryTreeMirror binaryTreeMirror = new _18_BinaryTreeMirror();
        binaryTreeMirror.Mirror(treeNode1);
        System.out.println();
        System.out.println(treeNode1.val);
        _60_PrintBinaryTreeEveryLine printBinaryTreeEveryLine = new _60_PrintBinaryTreeEveryLine();
        ArrayList<ArrayList<Integer>> print =
                printBinaryTreeEveryLine.Print(treeNode1);
        print.stream().forEach(a->{
           for(int i=0;i<a.size();i++){
               System.out.print(a.get(i)+" ");
           }
            System.out.println();
        });
    }
}
