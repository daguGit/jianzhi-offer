package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过
 * 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 */
public class _61_SerialiseBinaryTree {
    /**
     * 思路：
     * 1、考虑使用层遍历
     * 2、先获得说的深度，
     * 3、使用深度构建满二叉树
     * -T、特殊情况 二叉树为空
     * -A、将节点入队列，当遇到空节点时，构造假的节点
     * -B、构建字符串时，遇到假节点 使用 '#'号代替
     * -C、末尾添加 '!'
     *
     * @param root
     * @return
     */
    public String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        //获取树的深度
        int dept = this.dept(root);
        //获取树总的节点树
        int count = (int) Math.pow(2, dept) - 1;
        deque.add(root);
        while (!deque.isEmpty() && count > 0) {
            TreeNode pop = deque.pop();

            if (pop.left == null) {
                //如果左子树为空，构建一个假的节点
                deque.add(new TreeNode(Integer.MIN_VALUE));
            } else {
                deque.add(pop.left);
            }
            if (pop.right == null) {
                deque.add(new TreeNode(Integer.MIN_VALUE));
            } else {
                deque.add(pop.right);
            }

            if (pop == null || pop.val == Integer.MIN_VALUE) {
                sb.append("#,");

            } else {
                sb.append(pop.val + ",");
            }
            count--;
        }
        sb.append('!');
        return sb.toString();
    }

    /**
     * 思路：
     * 1、通过层序遍历得到的字符串解析树
     * 2、splits(flag) 构建节点
     * -A、splits[0] 构建根节点 入队列
     * -B、pop队列->pop
     * -C、每次读两个字符，将其构建成字符串 并Integer.parseInt(),构建成pop节点的左右节点
     * -D、直到flag小于str.length-1或者读到最后一个 '!' 为止；
     *
     * @param str
     * @return
     */
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        String[] splits = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        deque.add(root);
        //节点标记数
        int flag = 1;
        while (flag < splits.length - 1 && !splits[flag].equals("！")) {
            if (flag == 5) {
                System.out.println();
            }
            String cLeft = splits[flag];
            String cRight = splits[++flag];
            flag++;
            if (cLeft.equals("#") && cRight.equals("#")) {
                continue;
            }
            TreeNode pop = deque.pop();
            if (cLeft.equals("#")) {

            } else {
                TreeNode treeNode = new TreeNode(Integer.parseInt(cLeft + ""));
                pop.left = treeNode;
                deque.add(treeNode);
            }
            if (cRight.equals("#")) {

            } else {
                TreeNode treeNode = new TreeNode(Integer.parseInt(cRight + ""));
                pop.right = treeNode;
                deque.add(treeNode);
            }

        }
        return root;
    }

    /**
     * 获取某棵树的深度
     *
     * @param root
     * @return
     */
    private int dept(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(dept(root.left), dept(root.right)) + 1;
        }
    }

    /*******************************以下是参考网上的解法************************************/
    String Serialize_Other(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Serialize2(root, sb);
        return sb.toString();
    }

    void Serialize2(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        Serialize2(root.left, sb);
        Serialize2(root.right, sb);
    }

    int index = -1;

    TreeNode Deserialize_Ohter(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] strs = str.split(",");
        return Deserialize2(strs);
    }

    TreeNode Deserialize2(String[] strs) {
        index++;
        if (!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize2(strs);
            root.right = Deserialize2(strs);
            return root;
        }
        return null;
    }


    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(5);
//        TreeNode treeNode2 = new TreeNode(3);
//        TreeNode treeNode3 = new TreeNode(7);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        TreeNode treeNode4 = new TreeNode(2);
////        TreeNode treeNode5 = new TreeNode(4);
//        treeNode2.left = treeNode4;
////        treeNode2.right = treeNode5;
//        TreeNode treeNode6 = new TreeNode(6);
//        TreeNode treeNode7 = new TreeNode(8);
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;

        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode4;
        treeNode1.right = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode4.left = treeNode3;
        TreeNode treeNode2 = new TreeNode(2);
        treeNode3.left = treeNode2;
        _61_SerialiseBinaryTree serialiseBinaryTree = new _61_SerialiseBinaryTree();
        int dept = serialiseBinaryTree.dept(treeNode1);
        System.out.println(dept);

        String serialize = serialiseBinaryTree.Serialize(treeNode1);
        System.out.println(serialize);
        TreeNode deserialize = serialiseBinaryTree.Deserialize(serialize);
        System.out.println(deserialize);
    }
}
