package com.xujinshan.leetcode.code0103;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，
 * 以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode lef, TreeNode right) {
        this.val = val;
        this.left = lef;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 初始化保存结果
        List<List<Integer>> result = new LinkedList<>();
        // 节点为空则直接返回
        if (root == null) {
            return result;
        }
        // 队列用于层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 首先将根节点插入队列
        queue.offer(root);
        // 设置遍历方向，初始值为从左到右
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            // Deque 支持在俩端插入和删除的集合
            Deque<Integer> levList = new LinkedList<>();
            int size = queue.size();
            // 循环遍历获取队列中元素
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 判断遍历方向
                if (isOrderLeft) {
                    // 从左到右插入，即在后面插入元素
                    levList.offerLast(cur.val);
                } else {
                    // 从右往左插入，即从前面插入元素
                    levList.offerFirst(cur.val);
                }
                // 左右孩子不为空，则将其插入其中
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // 插入其中一次的遍历结果
            result.add(new LinkedList<>(levList));
            // 改变遍历的方向
            isOrderLeft = !isOrderLeft;
        }
        return result;
    }
}

/**
 * 测试
 */
public class Study0103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null),
                        new TreeNode(7, null, null)));
        List<List<Integer>> result = new Solution().zigzagLevelOrder(root);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
