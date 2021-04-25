package com.xujinshan.offer.offer32_I;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 32_I -- 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
 * 层次遍历
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        // 如果根节点为空，则直接返回一个长度为0 的数字
        if (root == null) {
            return new int[0];
        }
        // 建立队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 建立结果集合
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 出队列
            TreeNode cur = queue.poll();
            result.add(cur.val);
            // 左节点不为空，将左节点插入
            if (cur.left != null) {
                queue.add(cur.left);
            }
            // 右节点不为空，将右节点插入
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        // 将集合变成数组返回
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}

public class Offer32_I {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(Arrays.toString(new Solution().levelOrder(root)));
    }
}
