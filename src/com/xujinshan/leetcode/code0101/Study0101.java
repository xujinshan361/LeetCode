package com.xujinshan.leetcode.code0101;

/**
 * 0101-对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */

import java.util.LinkedList;
import java.util.Queue;

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
 * 递归
 */
class Solution01 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}

/**
 * 迭代方法
 * 首先引入一个队列，初始化时把根节点入队列俩次。每次提前俩个节点并比较值（队列中每俩个连续的节点应该是
 * 相等的，而且它们的子树互为镜像）然后将两个节点的左右子节点按照相反的顺序插入队列中，当队列为空时，
 * 或者检测到不对称时，算法结束。
 */
class Solution02 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || u.val != v.val) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}


public class Study0101 {
    public static void main(String[] args) {
        System.out.println(new Solution01().isSymmetric(
                new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null))
                        , new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null)))));
    }
}
