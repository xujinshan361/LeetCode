package com.xujinshan.leetcode.code0098;

/**
 * 0098-验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
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
 * 思路：
 * 如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它根节点的值，若它的右子树不为空，则右子树
 * 上的所有节点君大于它的根节点的值，它的左右子树也为二叉搜索树。
 * <p>
 * 设计一个递归函数 helper(root, lower, upper) 来递归判断，函数表示考虑root为根的子树，判断
 * 子树中所有节点的值是否都在 (l,r)的范围呢你（开区间）。如果root 节点的值val 不在范围内说明不
 * 满足条件直接返回，否则继续递归调用检查它的左右子树是否满足，如果都满足才说明是一棵二叉搜索树。
 * <p>
 * 根据二叉搜索树的性质，在递归调用左子树时，我们需要把上界 upper 改为 root.val，
 * 即调用 helper(root.left, lower, root.val)，因为左子树里所有节点的值均小于它的根节点的值。
 * 同理递归调用右子树时，我们需要把下界 lower 改为 root.val，
 * 即调用 helper(root.right, root.val, upper)。
 * <p>
 * 函数递归调用的入口为 helper(root, -inf, +inf)， inf 表示一个无穷大的值。
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 递归调用判断
     *
     * @param root
     * @param lower
     * @param upper
     * @return
     */
    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!helper(root.left, lower, val)) {
            return false;
        }
        if (!helper(root.right, val, upper)) {
            return false;
        }
        return true;
    }
}

/**
 * 测试
 */
public class Study0098 {
    public static void main(String[] args) {
        System.out.println(new Solution().isValidBST(
                new TreeNode(2, new TreeNode(1, null, null),
                        new TreeNode(3, null, null))));
    }
}
