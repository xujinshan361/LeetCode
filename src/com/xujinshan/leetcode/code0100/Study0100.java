package com.xujinshan.leetcode.code0100;

/**
 * 0100-相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
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

    ;

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
 * 深度优先搜索
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // 如果俩个都为 null ，则一定相等
            return true;
        } else if (p == null || q == null) {
            // 只有一个为 null
            return false;
        } else if (p.val != q.val) {
            // 俩个根节点的值不相等
            return false;
        } else {
            // 递归调用
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}

public class Study0100 {
    public static void main(String[] args) {
        System.out.println(new Solution().isSameTree(new TreeNode(1, new TreeNode(2, null, null),
                new TreeNode(3, null, null)), new TreeNode(1, new TreeNode(2, null, null),
                new TreeNode(3, null, null))));
    }
}
