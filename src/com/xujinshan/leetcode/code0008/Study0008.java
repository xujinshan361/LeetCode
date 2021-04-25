package com.xujinshan.leetcode.code0008;

/**
 * 0008-字符串转整数(atoi)
 * 实现一个atoi函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后尽可能多的先序数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：
 * 假如该字符串中第一个非空字符不是一个有效数整数字符，字符串为空或者字符串仅包含空白字符时，
 * 则你的函数不需要进行转换，即无法进行有效转换。
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * <p>
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * <p>
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * <p>
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * <p>
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 */
class Solution {
    public int myAtoi(String str) {
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
public class Study0008 {
    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("  -1234"));
    }
}
