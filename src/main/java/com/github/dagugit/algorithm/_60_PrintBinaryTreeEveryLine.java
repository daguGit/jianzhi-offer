package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 把二叉树打印成多行
 * <p>
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class _60_PrintBinaryTreeEveryLine {
    /**
     * 思路
     * -A:使用队列遍历树
     * -B：使用next和count 记录，next记录当前行有多少个，count记录队列中当前行有多少个
     * -C:遍历下一行一个节点 next++；同时打印此行一个数值 count--；当count==0时，说明此行已经打印完，另count = next，new List并添加。
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> returnLists = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList();
        if (pRoot == null) {
            return returnLists;
        }


        deque.add(pRoot);
        int count = 1;
        int next = 0;
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            count--;
            list.add(pop.val);

            if (pop.left != null) {
                deque.add(pop.left);
                next++;
            }
            if (pop.right != null) {
                deque.add(pop.right);
                next++;
            }
            if (count == 0) {
                returnLists.add(new ArrayList<Integer>(list));
                list.clear();
                count = next;
                next = 0;
            }
        }
        return returnLists;
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
        _60_PrintBinaryTreeEveryLine printBinaryTreeEveryLine = new _60_PrintBinaryTreeEveryLine();
        ArrayList<ArrayList<Integer>> print = printBinaryTreeEveryLine.Print(treeNode1);
        System.out.println(print);
    }

}
