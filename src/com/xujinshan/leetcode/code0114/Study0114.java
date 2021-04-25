package com.xujinshan.leetcode.code0114;

/**
 * 0114-二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 * <p>
 * <p>
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * <p>
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */

import java.util.ArrayList;
import java.util.List;

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

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        // 保存先序遍历结果
        List<TreeNode> list = new ArrayList<>();
        // 先序遍历
        preOrder(root, list);
        // 获取节点长度
        int size = list.size();
        // 循环构建单链表
        for (int i = 1; i < size; i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            // left 为空，使用right 连接
            pre.left = null;
            pre.right = cur;
            pre = cur;
        }
    }

    /**
     * 先序遍历
     *
     * @param root 根节点
     * @param list 保存先序遍历结果
     */
    private void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}

/**
 * 测试
 */
public class Study0114 {
    public static void main(String[] args) {
        // 创建测试用例
        TreeNode root = new TreeNode(1, new TreeNode(2,
                new TreeNode(3, null, null),
                new TreeNode(4, null, null)),
                new TreeNode(5, null,
                        new TreeNode(6, null, null)));
        // 调用
        new Solution().flatten(root);

        // 遍历
        System.out.println("遍历：");
        TreeNode p = root;
        while (p != null) {
            System.out.print(p.val + "\t");
            p = p.right;
        }
    }
}
