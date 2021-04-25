package com.xujinshan.offer.offer07;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 07 -- 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left,TreeNode right){
        this.val =val;
        this.left = left;
        this.right =right;
    }
}
class Solution {
    /**
     * 通过HashMap 来快速定位根节点
     * 对于HashMap 中的键值对，键表示一个元素(节点的值)，值表示其在中序遍历中出现的位置
     */
    private Map<Integer, Integer> indexMap;

    /**
     * 递归构造二叉树
     *
     * @param preorder       前序遍历序列
     * @param inorder        中序遍历序列
     * @param preorder_left  前序遍历的的左边界
     * @param preorder_right 前序遍历的右边界
     * @param inorder_left   中序遍历的左边界
     * @param inorder_right  中序遍历的右边界
     * @return
     */
    TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点是根节点
        int preorder_root = preorder_left;
        // 中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    /**
     * 建立二叉树
     *
     * @param preorder 前序遍历结果
     * @param inorder  中序遍历结果
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
public class Offer07 {
    /**
     * 前序遍历二叉树
     *
     * @param root 根节点
     */
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历二叉树
     *
     * @param root 根节点
     */
    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + "\t");
        inOrder(root.right);
    }

    /**
     * 测试输出
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println("前序遍历：");
        preOrder(root);
        System.out.println("\n中序遍历：");
        inOrder(root);
    }
}
