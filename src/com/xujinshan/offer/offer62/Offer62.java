package com.xujinshan.offer.offer62;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer 62 -- 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字
 * （删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
class Solution {
    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; i++) { // 相当于移除n-1 个元素
            f = (m + f) % i;      // 每次需要对元素个数取余
        }
        return f;
    }
}

public class Offer62 {
    public static void main(String[] args) {
        System.out.println(new Solution().lastRemaining(5, 3));
    }
}
