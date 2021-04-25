package com.xujinshan.leetcode.code0509;

/**
 * 0509-斐波拉契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * 给定 N，计算 F(N)。
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * 提示：
 *
 *     0 ≤ N ≤ 30
 */


/**
 * 暴力破解，通过不了
 */
class Solution01{
    int fib(int N){
        if(N==1||N==2){
            return 1;
        }
        return fib(N-1)+fib(N-2);
    }
}

/**
 * 带有忘备录
 */
class Solution02{
    int fib(int N){
        if(N <1){
            return 0;
        }
        int[] memo = new int[N+1];
        return helper(memo,N);
    }
    private int helper(int[] memo, int n){
        // 初始条件
        if(n==1||n==2){
            return 1;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n]=helper(memo,n-1)+helper(memo,n-2);
        return memo[n];
    }
}
public class Study0509 {
    public static void main(String[] args) {
        System.out.println(new Solution02().fib(10));
    }
}
