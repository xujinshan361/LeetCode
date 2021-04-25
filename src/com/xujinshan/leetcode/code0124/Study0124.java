package com.xujinshan.leetcode.code0124;

/**
 * 0124-二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，
 * 达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出：6
 * <p>
 * 示例 2：
 * <p>
 * 输入：[-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 输出：42
 */

/**
 * Definition for a binary tree node
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
 * 递归实现
 */

class Solution {
    int result = Integer.MIN_VALUE;     // 用于保存结果

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return result;
    }

    private int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * 递归计算左右子节点的最大贡献值
         * 只有在最大贡献值大于0 时， 才会选取对应子节点
         */
        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));
        /**
         * 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
         * 更新答案
         */
        result = Math.max(result, left + right + root.val);
        /**
         * 返回节点的最大贡献值
         */
        return root.val + Math.max(left, right);
    }
}

public class Study0124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        System.out.println(new Solution().maxPathSum(root));
    }
}
