package com.xujinshan.leetcode.code0099;

/**
 * 0099-恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * <p>
 * 提示：
 * <p>
 * 树上节点的数目在范围 [2, 1000] 内
 * -2^31 <= Node.val <= 2^31 - 1
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 *
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
 * 显示中序遍历
 */
class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    /**
     * 二叉树中序遍历
     * @param root  树根节点
     * @param nums  开辟一个列表，用来记录中序遍历得到值序列
     */
    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    /**
     * 寻找需要交换的俩个数值
     * @param nums
     * @return
     */
    public int[] findTwoSwapped(List<Integer> nums) {
        // 获取中序序列的长度
        int n = nums.size();
        // 初始化x,y
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; i++) {
            // 找到第一个
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    /**
     *
     * @param root 根节点
     * @param count 需要交换的个数
     * @param x 第一个不满足条件的数
     * @param y 第二个不满足条件的数
     */
    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }
}

public class Study0099 {
    public static void main(String[] args) {
        // 构建测试用例
        TreeNode tree = new TreeNode(1, new TreeNode(3, null, new TreeNode(2, null, null)), null);
        // 调用恢复函数
        new Solution().recoverTree(tree);
        // 输出打印结果--先序遍历结果
        System.out.println("恢复的二叉树先序遍历结果为：");
        new Study0099().preorder(tree);
    }

    /**
     * 二叉树先序遍历
     * @param root
     */
    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val+"\t");
        preorder(root.left);
        preorder(root.right);
    }
}
