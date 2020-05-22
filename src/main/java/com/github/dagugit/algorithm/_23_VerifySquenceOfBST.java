package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

/**
 * 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class _23_VerifySquenceOfBST {
    /**
     * 思路：
     * 1、特殊情况
     * -A:当sequence==null||sequence.length=0 return false
     * -B：当sequence.length==1 return true
     * 2、二叉搜索树的后续遍历，最后节点为根节点。只要满足小于根节点、右子树大于根节点即可
     * -A：获取sequence.length length
     * -B: 找到 < sequence[length-1] 的位置，将sequence分成 left、right两部分
     * -C：递归left、right部分需满足搜索二叉树
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence == null || sequence.length == 0) {
            return false;
        }
        else if(sequence.length == 1) {
            return true;
        }

        return JudgePostOrder(sequence, 0, sequence.length - 1);

    }

    public boolean JudgePostOrder(int[] sequence, int start, int end) {

        if(start >= end) {
            return true;
        }

        int i = start;
        while (i <= end && sequence[i] < sequence[end]) {
            i++;
        }

        for (int j = i; j <= end; j++) {
            if(sequence[j] < sequence[end]) {
                return false;
            }
        }

        return JudgePostOrder(sequence, start, i - 1) && JudgePostOrder(sequence, i, end-1);

    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        int[] array={1,3,2,5,7,9,4};
        _23_VerifySquenceOfBST verifySquenceOfBST = new _23_VerifySquenceOfBST();
        boolean b = verifySquenceOfBST.VerifySquenceOfBST(array);
        System.out.println(b);
    }
}
