package com.xujinshan.leetcode.code0111;

/**
 * 0111-二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

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
 * BFS
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * 队列
         */
        Queue<TreeNode> q = new LinkedList<>();
        /**
         *offer() 如果在可以不违反容量限制的情况下立即将指定的元素插入此队列，
         * 当使用容量受限的队列时，此方法通常比 add() 更可取，add()可能会通过引发
         * 异常而无法插入元素。
         */
        q.offer(root);
        // root 本身就是一层， depth 初始化为1
        int depth = 1;
        while (!q.isEmpty()) {
            // 获取队列的长度
            int sz = q.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < sz; i++) {
                // 取出队头元素
                TreeNode cur = q.poll();
                // 判断是否到达终点--左右孩子都为空
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                // 将cur的相邻节点加入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // 增加步数
            depth++;
        }
        return depth;
    }
}

/**
 * 测试
 */
public class Study0111 {
    public static void main(String[] args) {
        // 构造测试用例TreeNode
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null)
                , new TreeNode(7, null, null)));
        System.out.println(new Solution().minDepth(root));
    }
}
