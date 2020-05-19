package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class _58_SymmetricalBinaryTree {
    /**
     * 思路0：
     * 1、将root弄成两个，子树问题使用递归
     * 2、有且只有一个为空，return false；root1.val != root2.val return false；
     * <p>
     * 思路1：
     * -A:使用递归将tree翻转
     * -B:判断反转后的是否和原来的相同
     * 但是这种思路似乎有点麻烦
     * <p>
     * 思路2：
     * -A：使用quene从左到右横向遍历二叉树，从右到左横向遍历二叉树
     *
     * @param pRoot {5,3,3,4,#,#,4,2,#,#,2,#,#,#,1}
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetricalTree(pRoot, pRoot);
    }

    /**
     * 推荐使用此种方法，便于理解
     *
     * @param root1
     * @param root2
     * @return
     */
    boolean isSymmetricalTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1.left == null && root2.right != null) {
            return false;
        }
        if (root1.left != null && root2.right == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetricalTree(root1.left, root2.right) && isSymmetricalTree(root1.right, root2.left);
    }

    boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return true;
        }
        //记录从左到右横向节点
        Deque<TreeNode> left2Right = new ArrayDeque<TreeNode>();
        //记录从右到左横向节点
        Deque<TreeNode> right2Left = new ArrayDeque<TreeNode>();
        left2Right.add(pRoot);
        right2Left.add(pRoot);
        while (!left2Right.isEmpty() && !right2Left.isEmpty()) {
            TreeNode dequeHeadLeft = left2Right.pop();
            TreeNode dequeHeadRight = right2Left.pop();
            if (dequeHeadRight.val != dequeHeadLeft.val) {
                return false;
            }
            if (dequeHeadLeft.left != null) {
                left2Right.add(dequeHeadLeft.left);
            }
            if (dequeHeadLeft.right != null) {
                left2Right.add(dequeHeadLeft.right);
            }
            if (dequeHeadRight.right != null) {
                right2Left.add(dequeHeadRight.right);
            }
            if (dequeHeadRight.left != null) {
                right2Left.add(dequeHeadRight.left);
            }

        }
        return true;
    }

    /**
     * 测试广度优先遍历
     *
     * @param pRoot
     */
    public void DFS(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.add(pRoot);
        while (!deque.isEmpty()) {
            TreeNode dequeHead = deque.pop();
            System.out.println(dequeHead.val);
            if (dequeHead.left != null) {
                deque.add(dequeHead.left);
            }
            if (dequeHead.right != null) {
                deque.add(dequeHead.right);
            }
        }
    }

    public void DFS2(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        Deque<TreeNode> left2Right = new ArrayDeque<TreeNode>();
        Deque<TreeNode> right2Left = new ArrayDeque<TreeNode>();
        left2Right.add(pRoot);
        right2Left.add(pRoot);
        while (!left2Right.isEmpty() && !right2Left.isEmpty()) {
            TreeNode dequeHeadLeft = left2Right.pop();
            TreeNode dequeHeadRight = right2Left.pop();
            System.out.println(dequeHeadRight.val + " " + dequeHeadLeft.val + " " + (dequeHeadRight.val == dequeHeadLeft.val));
            if (dequeHeadLeft.left != null) {
                left2Right.add(dequeHeadLeft.left);
            }
            if (dequeHeadLeft.right != null) {
                left2Right.add(dequeHeadLeft.right);
            }
            if (dequeHeadRight.right != null) {
                right2Left.add(dequeHeadRight.right);
            }
            if (dequeHeadRight.left != null) {
                right2Left.add(dequeHeadRight.left);
            }

        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(4);
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;

        TreeNode treeNode6 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(1);
        treeNode4.left = treeNode6;
        treeNode5.right = treeNode7;
        _58_SymmetricalBinaryTree symmetricalBinaryTree = new _58_SymmetricalBinaryTree();
        boolean symmetrical = symmetricalBinaryTree.isSymmetrical(treeNode1);
        System.out.println(symmetrical);
    }
}
