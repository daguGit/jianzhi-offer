package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * <p>
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class _24_FindPath {
    ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();//存储当前的路径

    //***************借鉴网上的思想*****************//
    /**
     * 思路：
     * 1、类似递归先序遍历遍历
     * -A:特殊情况
     * --A1：target<0 root==null return paths
     * 2、在path中添加当前节点
     * 3、如果左右子树为空， target=root.varl，记录list
     * 4、如果左子树不空，递归左子树 target=target-root.val
     * 5、如果右子树不空，递归右子树 target=target-root.val
     * 6、在path中减去当前节点
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (target < 0) {
            return paths;
        }
        if (root == null) {
            return paths;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            paths.add(new ArrayList<Integer>(path));
        }
        if (root.val < target && root.left != null) {
            FindPath(root.left, target - root.val);
        }
        if (root.val < target && root.left != null) {
            FindPath(root.right, target - root.val);
        }
        //遍历完一条路径之后需要回溯
        path.remove(path.size() - 1);
        return paths;
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
        _24_FindPath findPath = new _24_FindPath();
        ArrayList<ArrayList<Integer>> arrayLists = findPath.FindPath(treeNode1, 7);
        for (int i = 0; i < arrayLists.size(); i++) {
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                System.out.print(arrayLists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
