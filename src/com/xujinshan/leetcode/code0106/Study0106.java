package com.xujinshan.leetcode.code0106;

/**
 * 0106-从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node
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

/**
 * 递归
 */
class Solution {
    int postIndex;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        // 从后序遍历的最后一个元素开始
        postIndex = postorder.length - 1;
        // 建立（元素，下标）键值对的哈希表
        int index = 0;
        for (Integer val : inorder) {
            indexMap.put(val, index++);
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int leftIndex, int rightIndex) {
        // 如果没有节点构造二叉树就结束
        if (leftIndex > rightIndex) {
            return null;
        }
        // 选择postIndex  位置元素作为当前子树根节点
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        // 根据root所在位置分为左右俩颗子树
        int index = indexMap.get(rootVal);

        // 下标减一
        postIndex--;

        /**
         * 这里需要注意的点：
         * 需要先创建右子树，再创建左子树的依赖关系
         * 在后序遍历的数组中整个数组是先存储左子树的节点再存储右子树的节点，最后存储
         * 根节点，如果按每次选择[后序遍历的最后一个节点]为根节点，则先被构造出来的应该是
         * 右子树
         */
        // 构造右子树
        root.right = helper(index + 1, rightIndex);
        // 构造左子树
        root.left = helper(leftIndex, index - 1);
        return root;
    }
}

/**
 * 测试
 */
public class Study0106 {
    public static void main(String[] args) {
        System.out.println("先序遍历结果为：");
        preOrder(new Solution().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }
}
