package com.xujinshan.offer.offer10_II;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 10_II -- 青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台
 * 阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 */

/**
 * 递归实现，便于理解，LeetCode不能通过，超出时间限制
 */
class Solution01 {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return (numWays(n - 1) + numWays(n - 2)) % 1000000007;
    }
}

/**
 * 使用数组进行优化
 */
class Solution02 {
    public int numWays(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
        }
        return result[n];
    }
}

/**
 * 三个变量进行存储，减少空间消耗
 */
class Solution03 {
    public int numWays(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % 1000000007;
        }
        return r;
    }
}

public class Offer10_II {

    public static void main(String[] args) {
        System.out.println(new Solution03().numWays(7));
    }
}
