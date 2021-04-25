package com.xujinshan.leetcode.code0070;

/**
 * 0070-爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * <p>
 * 分析：
 * 使用 f(x) 表示爬到第 x 级台阶的方案数，考虑到最后一步可能跨越一级台阶，也可能跨越俩级台阶，所以：
 * f(x) = f(x-1) + f(x-2)
 * 其中 f(0) = 1， f(1）= 1
 * <p>
 * 分析：
 * 使用 f(x) 表示爬到第 x 级台阶的方案数，考虑到最后一步可能跨越一级台阶，也可能跨越俩级台阶，所以：
 * f(x) = f(x-1) + f(x-2)
 * 其中 f(0) = 1， f(1）= 1
 */

/**
 * 分析：
 * 使用 f(x) 表示爬到第 x 级台阶的方案数，考虑到最后一步可能跨越一级台阶，也可能跨越俩级台阶，所以：
 * f(x) = f(x-1) + f(x-2)
 * 其中 f(0) = 1， f(1）= 1
 */

/**
 * 递归实现，便于理解，LeetCode不能通过，超出时间限制
 */
class Solution01 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

/**
 * 使用数组进行优化
 */
class Solution02 {
    public int climbStairs(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}

/**
 * 三个变量进行存储，减少空间消耗
 */
class Solution03 {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}

/**
 * 测试
 */
public class Study0070 {
    public static void main(String[] args) {
        System.out.println(new Solution03().climbStairs(3));
    }
}
