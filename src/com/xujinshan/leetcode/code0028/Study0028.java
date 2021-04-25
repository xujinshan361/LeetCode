package com.xujinshan.leetcode.code0028;

/**
 * 0028-实现strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
 * 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */

/**
 * 暴力解法
 */
class Solution {
    public int strStr(String haystack, String needle) {
        // 当needle 是空字符串时返回0
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); ++i) {
            // 当母字符串剩余长度小于子字符串时返回 -1
            if ((haystack.length() - i) < needle.length()) {
                return -1;
            }
            // 遇到一个与子字符串头部相等时，逐一比较，全部相同时就返回索引值，否则继续外层循环
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                for (int j = 0; j < needle.length(); ++j) {
                    if (haystack.charAt(i + j) != needle.charAt((j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }
}

/**
 * 测试类
 */
public class Study0028 {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
    }
}
