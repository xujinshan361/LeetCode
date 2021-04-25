package com.xujinshan.offer.offer26;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 26 -- 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 */

import com.sun.source.tree.Tree;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        // 表示B没有节点了
        if (B == null) {
            return true;
        }
        // 表示A 没有节点了,或者值不相同的时候
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}

public class Offer26 {
    public static void main(String[] args) {
        TreeNode B = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        TreeNode A = new TreeNode(3, B, new TreeNode(5));
        System.out.println(new Solution().isSubStructure(A, B));
    }
}
