package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeLinkNode;

/**
 * 二叉树的下一个结点
 * 
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author Administrator
 */
public class _57_GetBinaryTreeNextNode {
    /**
     * 思路：(画了一个树形图想到的)
     * 因为中序遍历下一个节点是遍历右子树，所以以右子树=null？为分类依据
     * 1、右子树为空：
     * -A、当前节点不存在父节点，return null
     * -B、当前节点是父节点的左子树，找到当前节点的父节点
     * -C、当前节点是父节点的右子树，向上找、直到当前节点是其父节点的左子树；否则返回空
     * 2、右子树不为空：
     * -A：右子树根节点有左节点：递归找到最左节点
     * -B：右子树根节点没有左节点：返回当前节点
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode left = pNode.left;
        TreeLinkNode right = pNode.right;
        TreeLinkNode temp;
        if (right == null) {
            TreeLinkNode parent = pNode.next;
            //当前节点不存在父节点，直接返回null
            if (parent == null) {
                return null;
            }
            if (parent.left == pNode) {
                return parent;
            } else if (parent.right == pNode) {
                //开始向上找，直到当前接二店是其父节点的左子树
                temp = pNode;
                while (parent.right == temp) {
                    temp = parent;
                    parent = parent.next;
                    //如果是最右侧节点，一直向上找永远不能满足条件，当parent==null是返回null
                    if (parent == null) {
                        return null;
                    }
                }
                return parent;
            }
        } else {
            if (right.left != null) {
                while (true) {
                    temp = right.left;
                    if (temp.left == null) {
                        return temp;
                    }
                    temp = temp.left;
                }
            } else if (right.left == null) {
                return right;
            }
        }


        return null;
    }

    /**
     * 测试中序遍历
     *
     * @param pNode
     */
    public void testInorderTraversal(TreeLinkNode pNode) {
        if (pNode == null) {
            return;
        }
        if (pNode.left != null) {
            testInorderTraversal(pNode.left);
        }
        System.out.println(pNode.val);
        if (pNode.right != null) {
            testInorderTraversal(pNode.right);
        }
    }

    public static void main(String[] args) {
        TreeLinkNode treeNode1 = new TreeLinkNode(1);
        TreeLinkNode treeNode2 = new TreeLinkNode(2);

        TreeLinkNode treeNode3 = new TreeLinkNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.next = treeNode1;
        treeNode3.next = treeNode1;
        TreeLinkNode treeNode4 = new TreeLinkNode(4);
        TreeLinkNode treeNode5 = new TreeLinkNode(5);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.next = treeNode2;
        treeNode5.next = treeNode2;

        TreeLinkNode treeNode6 = new TreeLinkNode(6);
        TreeLinkNode treeNode7 = new TreeLinkNode(7);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode6.next = treeNode3;
        treeNode7.next = treeNode3;
        TreeLinkNode treeNode8 = new TreeLinkNode(8);
        TreeLinkNode treeNode9 = new TreeLinkNode(9);
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode8.next = treeNode4;
        treeNode9.next = treeNode4;
        TreeLinkNode treeNode10 = new TreeLinkNode(10);
        TreeLinkNode treeNode11 = new TreeLinkNode(11);
        treeNode5.left = treeNode10;
        treeNode5.right = treeNode11;
        treeNode10.next = treeNode5;
        treeNode11.next = treeNode5;
        _57_GetBinaryTreeNextNode getBinaryTreeNextNode = new _57_GetBinaryTreeNextNode();

        System.out.println(getBinaryTreeNextNode.GetNext(treeNode1).val);
        System.out.println(getBinaryTreeNextNode.GetNext(treeNode8).val);
        System.out.println(getBinaryTreeNextNode.GetNext(treeNode9).val);
        System.out.println(getBinaryTreeNextNode.GetNext(treeNode11).val);
        System.out.println(getBinaryTreeNextNode.GetNext(treeNode7).val);

    }
}
