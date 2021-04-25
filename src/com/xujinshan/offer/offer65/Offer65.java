package com.xujinshan.offer.offer65;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer 65 -- 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * 提示：
 *
 *     a, b 均可能是负数或 0
 *     结果不会溢出 32 位整数
 */
class Solution {
    // TODO
    public int add(int a,int b){
        int c  = (a&b)<<1;
        int d = a^b;
        return d|c;
    }
}
public class Offer65 {
    public static void main(String[] args) {
        System.out.println(new Solution().add(1,1));
        System.out.println(0^0);
    }
}
