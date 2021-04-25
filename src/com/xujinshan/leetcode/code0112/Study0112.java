package com.xujinshan.leetcode.code0112;

/**
 * 0112-路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * <p>
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

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
 * 递归实现：
 * 归纳功能：询问是否存在当前节点root到叶子节点的路径，满足其路径和为 sum
 * 假设从根节点到当前节点的值之和为 val，可以将这个大问题转化成一个小问题：是否出在当前节点
 * 到叶子节点的路径，满足其路径和为sum-val.
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

/**
 * 测试
 */
public class Study0112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7, null, null),
                new TreeNode(2, null, null)), null)
                , new TreeNode(8, new TreeNode(13, null, null),
                new TreeNode(4, null, new TreeNode(1, null, null))));
        System.out.println(new Solution().hasPathSum(root, 22));
    }
}
