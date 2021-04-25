package com.xujinshan.leetcode.code0029;

/**
 * 0029-两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * <p>
 * 提示：
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 */

import java.nio.charset.IllegalCharsetNameException;

/**
 *  采用二分的思想，dividend 每次减去2^n 个divisor(尽可能多)，同时result 每次增加2^n
 */
class Solution {
    public int divide(int dividend, int divisor) {
        // 边界情况特殊处理
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        /**
         * 符号标志，为了方面计算，将所有的数都变成负数计算，因为负数可以表示的绝对值比正数大
         */
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        /**
         * 保存结果
         */
        int result = 0;
        /**
         * 将俩个数都变成负数处理
         */
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;
        /**
         * 执行减法的循环操作
         */
        while (dividend <= divisor) {
            int temp = divisor;
            int c = 1;
            while (dividend - temp <= temp) {
                // 移位操作
                temp = temp << 1;
                c = c << 1;
            }
            dividend -= temp;
            result += c;
        }
        return flag ? result : -result;
    }
}

/**
 * 测试类
 */
public class Study0029 {
    public static void main(String[] args) {
        System.out.println(new Solution().divide(7, -3));
    }
}
