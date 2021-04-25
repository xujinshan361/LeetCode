package com.xujinshan.nowcoder.nc045;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: xujinshan361@163.com
 * NowCoder045--实现二叉树先序，中序和后序遍历
 * 题目描述
 * 分别按照二叉树先序，中序和后序打印所有的节点。
 * 示例1
 * 输入
 *
 * {1,2,3}
 *
 * 返回值
 *
 * [[1,2,3],[2,1,3],[2,3,1]]
 *
 * 备注:
 *
 * n≤106n \leq 10^6n≤106
 *
 * 说明：本题目包含复杂数据结构TreeNode
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    // 添加构造器为了测试方便
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution{
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        List<Integer> preorderList = new LinkedList();
        List<Integer> inorderList = new LinkedList();
        List<Integer> postorderList = new LinkedList();
        preorder(root,preorderList);
        inorder(root,inorderList);
        postorder(root,postorderList);

        int[][] result = new int[3][preorderList.size()];
        for (int i = 0; i < preorderList.size(); i++) {
            result[0][i] =preorderList.get(i);
        }
        for (int i = 0; i < inorderList.size(); i++) {
            result[1][i] = inorderList.get(i);
        }
        for (int i = 0; i < postorderList.size(); i++) {
            result[2][i] =postorderList.get(i);
        }
        return result;
    }
    public void preorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }
    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
    public void postorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }
    }
}
public class NowCoder045 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int[][] result = new Solution().threeOrders(root);
        for (int i = 0; i < result[0].length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
