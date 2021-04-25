package com.xujinshan.offer.offer64;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 64 -- 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、
 * else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * <p>
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 */
class Solution {
    public int sumNums(int n) {
        if (n == 0) {
            return 0;
        }
        return sumNums(n - 1) + n;
    }
}

public class Offer64 {
    public static void main(String[] args) {
        System.out.println(new Solution().sumNums(3));
    }
}
