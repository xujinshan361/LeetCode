package com.xujinshan.leetcode.code0108;

/**
 * 0108-将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
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
 * 中序遍历，总是选择中间位置左边的数字作为根节点
 * 选择中间位置左侧的数字作为根节点，则根节点的下标为 mid=(left+right)/2, 此处为整除
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 递归实现中序遍历构造二叉树
     * @param nums  有序数组
     * @param left  构造过程中的左边界
     * @param right 构造过程中的右边界
     * @return
     */
    private TreeNode helper(int[] nums, int left, int right) {
        // 结束条件--递归出口
        if (left > right) {
            return null;
        }
        // 选择中间位置左侧的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}

/**
 * 测试
 */
public class Study0108 {
    public static void main(String[] args) {
        System.out.println("建立的二叉搜索树的先序遍历结果为：");
        preOrder(new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    /**
     * 二叉树先序遍历
     */
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }
}
