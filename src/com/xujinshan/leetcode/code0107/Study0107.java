package com.xujinshan.leetcode.code0107;


import java.util.*;

/**
 * 0107-二叉树的层次遍历II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 广度优先搜索
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 保存结果集
        List<List<Integer>> levelOrder = new LinkedList<>();
        // 为空则直接返回
        if (root == null) {
            return levelOrder;
        }
        // 队列实现广度优先搜索
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }
}

/**
 * 测试
 */
public class Study0107 {
    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().levelOrderBottom(
                new TreeNode(3, new TreeNode(9, null, null),
                        new TreeNode(20, new TreeNode(15, null, null),
                                new TreeNode(7, null, null))));
        System.out.println(result.toString());
    }
}
