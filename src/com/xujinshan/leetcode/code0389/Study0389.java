package com.xujinshan.leetcode.code0389;

/**
 * 0389-找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 */

/**
 * 分析：
 * 首先遍历字符串 s ，对其中的每个字符都将计数值加1；然后遍历字符串 t，对其中的每个字符计数值减1.
 * 当发现某个字符的计数值为负数说明该字符在字符串 t 中出现的 次数大于在字符串 s 中出现的次数，因此该
 * 字符为被添加字符。
 */
class Solution {
    public char findTheDifference(String s, String t) {
        int[] chart = new int[26];
        int sLength = s.length();
        int tLength = t.length();
        for (int i = 0; i < sLength; i++) {
            char ch = s.charAt(i);
            chart[ch - 'a']++;
        }
        for (int i = 0; i < tLength; i++) {
            char ch = t.charAt(i);
            chart[ch - 'a']--;
            if (chart[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
}

/**
 * 测试
 *
 */
public class Study0389 {
    public static void main(String[] args) {
        System.out.println(new Solution().findTheDifference("abcd", "abcde"));
    }
}
