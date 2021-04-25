package com.xujinshan.leetcode.code0144;

/**
 * 0144-二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    // 保存结果集
    List<Integer> result = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }

    /**
     *先序遍历
     * @param root
     */
    private void preOrder(TreeNode root) {
        // 节点为空，则直接返回，递归出口
        if (root == null) {
            return;
        }
        // 添加节点值
        result.add(root.val);
        // 递归调用左子树
        preOrder(root.left);
        // 递归调用右子树
        preOrder(root.right);
    }
}

/**
 * 迭代实现
 */
class Solution02 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 结果集
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 维护一个栈进行操作
        Deque<TreeNode> stack = new LinkedList<>();
        // 获取当前节点
        TreeNode currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                // 将当前节点值加入结果
                result.add(currentNode.val);
                // 当前节点入栈
                stack.push(currentNode);
                // 遍历左子树
                currentNode = currentNode.left;
            }
            // 当左子树为空时，开始出栈，遍历右子树
            currentNode = stack.pop();
            currentNode = currentNode.right;
        }
        return result;
    }
}

/**
 * 测试
 */
public class Study0144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(
                2, new TreeNode(3, null, null), null));
        System.out.println(new Solution02().preorderTraversal(root));
    }
}
