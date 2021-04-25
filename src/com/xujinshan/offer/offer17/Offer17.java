package com.xujinshan.offer.offer17;

import java.util.Arrays;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 17 -- 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
class Solution {
    public int[] printNumbers(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        int[] res = new int[result - 1];
        for (int i = 0; i < result - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}

public class Offer17 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().printNumbers(1)));
    }
}
