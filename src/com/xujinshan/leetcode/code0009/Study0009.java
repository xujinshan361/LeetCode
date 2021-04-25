package com.xujinshan.leetcode.code0009;
/**
 * 0009-回文数
 * 判断一个整数是否是回文数。回文数是指正序(从左向右)和倒序(从右向左)读都是一样的整数。
 * 示例1：
 * 输入：121
 * 输出：true
 * 示例2：
 * 输入：-121
 * 输出：121-
 * 解释：从左向右读，为-121。从右向左读，为121-。因此不是回文数
 * 示例3：
 * 输入：10
 * 输出：false
 * 解释:从右向左读，为01，因此不是一个回文数
 */

/**
 * 反转一半数字
 * 时间复杂度O(log n)
 */
class Solution01 {
    public boolean isPalindrome(int x) {
        // 特殊情况
        // 如果x小于0，或者x是以0结尾(整数0除外)则不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 反转数字保存的变量
        int revertedNumber = 0;
        while (x > revertedNumber) {
            // 反转操作，只需要反转数字的一半位数即可
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

}

/**
 * 变成字符串进行判断
 * 时间复杂度O(n)
 */
class Solution02 {
    public boolean isPalindrome(int x) {
        // 将数字变成字符串进行判断
        String s = String.valueOf(x);
        for (int i = 0; i <= s.length() / 2; i++) {
            // 只需要判断一半即可
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * 测试类
 */
public class Study0009 {
    public static void main(String[] args) {
        System.out.println(new Solution01().isPalindrome(121));
    }
}
