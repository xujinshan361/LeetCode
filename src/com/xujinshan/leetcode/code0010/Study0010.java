package com.xujinshan.leetcode.code0010;
/**
 * 0010-正则表达式匹配
 * 给你一个字符串 s 和 一个字符规律 p, 请你来实现一个支持'.'和'*'的正则表达式匹配。
 * '.'匹配任意单个字符
 * '*'匹配0个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s 的，而不是部分字符串。
 * 说明：
 * s可能为空，且只包含从 a-z 的小写字母
 * p可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */

/**
 * 动态规划解决
 */
class Solution {
    public boolean isMatch(String s, String p) {
        // 获取俩个字符串的长度
        int sLength = s.length();
        int PLength = p.length();
        // 状态转移表
        boolean[][] f = new boolean[sLength + 1][PLength + 1];
        // 俩个字符串都为空时，是匹配的
        f[0][0] = true;
        for (int i = 0; i <= sLength; ++i) {
            for (int j = 1; j <= PLength; ++j) {
                if (p.charAt(j - 1) == '*') {
                    // 匹配星号
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    // 匹配不是星号的情况
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[sLength][PLength];
    }

    // 判断s的第i位和p的第j位是否匹配
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        // . 匹配任意字符
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        // 比较俩个字符是否相等
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}

/**
 * 测试类
 */
public class Study0010 {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aab", "c*a*b*"));
    }
}
