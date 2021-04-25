package com.xujinshan.leetcode.code0096;

/**
 * 0096-不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */

/**
 *  动态规划
 *  思路：给定一个有序序列 1...n ,为了构建一棵二叉搜索树，可以遍历每个数字 i，将该数字作为树根，将
 *  1...(i-1)序列作为左子树，将 (i+1)...n 序列作为右子树，接着可以按照同样的方式递归构建左子树和
 *  右子树
 *
 *  算法：
 *  题目要求计算不同二叉搜索树的个数。可以定义俩个函数
 *      G(n):长度为 n 的序列构成不同的二叉搜索树的个数
 *      F(i,n):以i为根节点，序列长度为n的不同二叉搜索树的个数(1<= i<=n)
 *  可见：G(n)是需要求解的函数
 *  G(n) = F(1,n) + F(2,n) +...+ F(n,n)
 *  对于边界条件
 *      G(0) = 1
 *      G(1) = 1
 *
 *  给定序列 1...n ,选择数字 i 作为根，则根为 i 的所有二叉搜索树的集合是左子树集合和右子树集合的
 *  笛卡尔积，对于笛卡尔积中的每个元素，加上根节点之后形成完整的二叉搜索树。
 *
 *  F(i,n) = G(i-1)*G(n-i)
 *
 *  所以 G(n) = G(0)*G(n-1) + G(1)*G(n-2) + G(2)*G(n-3) + ...
 *
 */
class Solution01 {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}

/**
 * 卡特兰数
 */
class Solution02 {
    public int numTrees(int n) {
        // 使用long防止计算过程中产生溢出
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) c;
    }
}

/**
 * 测试
 */
public class Study0096 {
    public static void main(String[] args) {
        System.out.println(new Solution02().numTrees(3));
    }
}
