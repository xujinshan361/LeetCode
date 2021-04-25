package com.xujinshan.leetcode.code0113;
/**
 * 0113-路径总和II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
 * /  \    / \
 * 7    2  5   1
 * <p>
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

/**
 * 深度优先
 * 枚举每一条从根节点到叶子节点的路径。当遍历到叶子节点，且此时路径和恰为目标和时候，就找到了一
 * 条满足条件的路径
 */
class Solution {
    List<List<Integer>> result = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return result;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        // offerLast() 将指定元素插入队尾
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new LinkedList<>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        // pollLast() 删除最后一个元素
        path.pollLast();
    }
}

/**
 * 测试
 */
public class Study0113 {
    public static void main(String[] args) {
        // 构建示例二叉树
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11,
                new TreeNode(7, null, null), new TreeNode(2,
                null, null)), null), new TreeNode(8, new TreeNode(13,
                null, null), new TreeNode(4, new TreeNode(5,
                null, null), new TreeNode(1, null, null))));

        List<List<Integer>> result = new Solution().pathSum(root, 22);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
