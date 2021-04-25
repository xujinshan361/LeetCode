package com.xujinshan.leetcode.code0104;

/**
 * 0104-二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回它的最大深度 3 。
 */

import java.util.LinkedList;
import java.util.Queue;

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
 * 递归实现
 */
class Solution01 {
    public int maxDepth(TreeNode root) {
        // 如果根为空，则直接返回0
        if (root == null) {
            return 0;
        } else {  // 根不为空
            // 获取左子树深度
            int leftDepth = maxDepth(root.left);
            // 获取右子树深度
            int rightDepth = maxDepth(root.right);
            // 返回根的深度
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}

/**
 * 广度优先搜素
 * 思想：
 * 广度优先搜素的队列里放的是 当前层的所有节点 。每次扩展下一层的时候，不同于广度优先搜素的每次只
 * 从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行扩展，这样能保证每次扩展的时候队列
 * 里存放的都是当前层的所有节点，即一层一层地进行扩展，最后用一个变量 result 来维护扩展的次数，即
 * 为该二叉树的深度。
 */

class Solution02 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            // 保存当前层的所有元素个数
            int size = queue.size();
            // 当前层所有元素出队列，如果当前元素的左右孩子不为空，则添加进队列
            // 当前层元素全部出队列后，更新 result值
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            result++;
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Study0104 {
    public static void main(String[] args) {
        System.out.println(new Solution02().maxDepth(
                new TreeNode(3, new TreeNode(9, null, null),
                        new TreeNode(20, new TreeNode(15, null, null),
                                new TreeNode(7, null, null)))));
    }
}
