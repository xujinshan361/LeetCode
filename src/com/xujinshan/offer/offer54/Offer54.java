package com.xujinshan.offer.offer54;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 54 二叉搜索树中的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node
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
 * 二叉搜索树中，中序遍历结果即为从小到大的顺序，
 * 将结果保存在栈中，然后顺序输出第k个即为第k大的数
 */
class Solution01 {
    private Deque<TreeNode> order = new LinkedList<>();

    public int kthLargest(TreeNode root, int k) {
        inOrder(root);
        // 获取第k-1 个
        for (int i = 1; i < k; i++) {
            order.pop();
        }
        return order.pop().val;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        order.push(root);
        inOrder(root.right);
    }
}

/**
 * 逆序中序遍历， 右子树 ————> 根节点————> 左子树
 * 按照如此顺序，遍历即可得到从大到小的顺序，获取第k个即可截止
 */
class Solution02 {
    private int result;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        // 遍历 右子节点
        inOrder(root.right);
        // 计数，若 当前节点是第k个节点，结束递归，并记录 当前节点的值
        if (--this.k == 0) {
            this.result = root.val;
            return;
        }
        // 遍历 左子节点
        inOrder(root.left);
    }

}

public class Offer54 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new
                TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println(new Solution02().kthLargest(root, 1));
    }
}
