package com.xujinshan.offer.offer55_I;

/**
 * 剑指 Offer55_I 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、
 * 叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 *
 * 提示：
 *
 *     节点总数 <= 10000
 *
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
public class Offer55_I {
    public static void main(String[] args) {
        System.out.println(new Solution02().maxDepth(
                new TreeNode(3, new TreeNode(9, null, null),
                        new TreeNode(20, new TreeNode(15, null, null),
                                new TreeNode(7, null, null)))));
    }
}
