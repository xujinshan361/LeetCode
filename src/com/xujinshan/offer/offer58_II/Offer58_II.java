package com.xujinshan.offer.offer58_II;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer 58_II 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * 限制：
 * <p>
 * 1 <= k < s.length <= 10000
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n, s.length())).append(s.substring(0, n));
        return sb.toString();
    }
}

public class Offer58_II {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseLeftWords("abcdefg", 2));
    }
}
