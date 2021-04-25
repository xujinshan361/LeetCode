package com.xujinshan.offer.offer67;

/**
 * 剑指Offer 67 -- 把字符串转成整数
 */
class Solution {
    public int strToInt(String str) {
        // 保存结果
        int result = 0;
        // 设置标志位，判断str转换后的整数是正数还是负数，1表示正数，-1表示负数
        int flag = 1;
        // 设置访问str的索引
        int i = 0;
        // 设置循环，将标志索引移动到第一个非空字符位置
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        // 如果标志索引等于字符串长度，表示已经结束，则直接返回默认result(默认值0)；
        if (i == str.length()) {
            return result;
        }
        // 判断第一个非空格字符是否为负号
        if (str.charAt(i) == '-') {
            flag = -1;
        }
        // 判断第一个非空格字符是否为符号，如果为符号，则索引向右移动
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            i++;
        }
        // 循环向右移动，遇到数字则将其加入result中
        // 同时考虑是否越界问题
        while (i < str.length() && isDigti(str.charAt(i))) {
            int r = str.charAt(i) - '0';
            if (flag == 1) {
                // 判断是否正向越界
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && r > 7)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                // 判断是否负向越界
                if (-result < Integer.MIN_VALUE / 10 || (-result == Integer.MIN_VALUE / 10 && r > 8)) {
                    return Integer.MIN_VALUE;
                }
            }
            // 计算结果
            result = result * 10 + r;
            i++;
        }
        return flag > 0 ? result : -result;
    }

    /**
     * 判断字符是否是数字字符，是则返回true，否则返回false
     *
     * @param c
     * @return
     */
    private boolean isDigti(char c) {
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }
}

/**
 * 测试类
 */
public class Offer67 {
    public static void main(String[] args) {
        System.out.println(new Solution().strToInt("  -1234"));
    }
}
