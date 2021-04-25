package com.xujinshan.offer.offer10_I;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 10_I -- 斐波拉契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
 * 斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * <p>
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 */

/**
 * 暴力破解，通过不了
 */
class Solution01 {
    int fib(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return (fib(N - 1) + fib(N - 2)) % 1000000007;
    }
}

/**
 * 带有忘备录
 */
class Solution02 {
    int fib(int N) {
        if (N < 1) {
            return 0;
        }
        int[] memo = new int[N + 1];
        return helper(memo, N);
    }

    private int helper(int[] memo, int n) {
        // 初始条件
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = (helper(memo, n - 1) + helper(memo, n - 2)) % 1000000007;
        return memo[n];
    }
}

public class Offer10_I {
    public static void main(String[] args) {
        System.out.println(new Solution02().fib(5));
    }
}
