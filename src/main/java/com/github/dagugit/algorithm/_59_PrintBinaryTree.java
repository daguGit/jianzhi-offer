package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 按之字形顺序打印二叉树
 * <p>
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class _59_PrintBinaryTree {
    /**
     * 思路1：
     * -A：声明两个队列，dequeLeft、dequeRight
     * -B：遍历树每一行，轮流装入这两个队列，
     * -C: 设置深度，根据深度奇偶性 读出队列的值，reverse
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> integers;
        ArrayDeque<TreeNode> dequeLeft = new ArrayDeque<>();
        ArrayDeque<TreeNode> dequeRight = new ArrayDeque<>();

        if (pRoot == null) {
            return lists;
        }
        int depth = 0;
        dequeLeft.push(pRoot);
        while(!dequeLeft.isEmpty()||!dequeRight.isEmpty()){
            if (depth % 2 == 0) {
                integers = new ArrayList<Integer>();
                while (!dequeLeft.isEmpty()) {
                    TreeNode pop = dequeLeft.pop();
                    integers.add(pop.val);
                    if (pop.left != null) {
                        dequeRight.add(pop.left);
                    }
                    if (pop.right != null) {
                        dequeRight.add(pop.right);
                    }
                }
//                Collections.reverse(integers);
                lists.add(integers);
            } else {
                integers = new ArrayList<Integer>();
                while (!dequeRight.isEmpty()) {
                    TreeNode pop = dequeRight.pop();
                    integers.add(pop.val);
                    if (pop.left != null) {
                        dequeLeft.add(pop.left);
                    }
                    if (pop.right != null) {
                        dequeLeft.add(pop.right);
                    }
                }
                Collections.reverse(integers);
                lists.add(integers);
            }
            depth++;
        }

        return lists;
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

        _59_PrintBinaryTree printBinaryTree = new _59_PrintBinaryTree();
        ArrayList<ArrayList<Integer>> print = printBinaryTree.Print(treeNode1);
        System.out.println(print.toString());
    }
}
