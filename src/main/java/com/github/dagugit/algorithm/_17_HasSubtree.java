package com.github.dagugit.algorithm;


import com.github.dagugit.algorithm.common.TreeNode;

import java.util.ArrayList;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class _17_HasSubtree {
    /**
     * 思路:
     * 1、特殊情况
     * -A：root1==null，return null；
     * -B：root2==null，return null；
     * 2、在root1中找到与root2根节点相同的节点，判断以此节点为根节点是否与root2相同
     * -A:借鉴镜像的思路，分成以下几种情况
     * -B:root1==null&&root2==null return true
     * -C:root1！=null&&root2=null return true
     * -D:root1==null&&root2!=null return false
     * -E:root1.val!=root2.val return false
     * -F:其他 递归
     * <p>
     * 思路2:
     * 1: 借鉴_2020_05_25_SerialiseBinaryTree的思路将树序列化成字符串，s1与s2
     * 2：判断s2是否是s1的子串
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return false;
        }

        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        this.preList(root1, treeNodes);
        ArrayList<TreeNode> commonNodes = this.getCommonNode(treeNodes, root2);
        if (commonNodes.size() == 0) {
            return false;
        }
        for (int i = 0; i < commonNodes.size(); i++) {
            boolean subTree = isSubTree(commonNodes.get(i), root2);
            if (subTree) {
                return true;
            }
        }
        return false;
    }

    boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }

//        if (root1.left == null && root2.left != null) {
//            return false;
//        }
//        if (root1.right == null && root2.right != null) {
//            return false;
//        }
        if (root1.val != root2.val) {
            return false;
        }

        return isSubTree(root1.left, root2.left)
                && isSubTree(root1.right, root2.right);
    }

    private ArrayList<TreeNode> getCommonNode(ArrayList<TreeNode> treeNodes, TreeNode root2) {
        ArrayList<TreeNode> commonNodes = new ArrayList<>();
        for (int i = 0; i < treeNodes.size(); i++) {
            if (treeNodes.get(i).val == root2.val) {
                commonNodes.add(treeNodes.get(i));
            }
        }
        return commonNodes;
    }

    public void preList(TreeNode root, ArrayList<TreeNode> list) {
        list.add(root);
        if (root.left != null) {
            preList(root.left, list);
        }
        if (root.right != null) {
            preList(root.right, list);
        }

    }
    /****************大佬的思路**********/
    public static boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            //如果找到了对应Tree2的根节点的点
            if(root1.val == root2.val){
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree2(root1.left,root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree2(root1.right,root2);
            }
        }
        //返回结果
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
    }

    public static void main(String[] args) {
        _17_HasSubtree hasSubtree = new _17_HasSubtree();

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
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        hasSubtree.preList(treeNode1, treeNodes);
        treeNodes.stream().forEach(a -> {
            System.out.println(a.val);
        });

        TreeNode treeNode03 = new TreeNode(3);
        TreeNode treeNode06 = new TreeNode(6);
        TreeNode treeNode07 = new TreeNode(7);
        treeNode03.left = treeNode06;
        treeNode03.right = treeNode07;
        boolean b = hasSubtree.HasSubtree(treeNode1, treeNode03);
        System.out.println(b);
    }
}
