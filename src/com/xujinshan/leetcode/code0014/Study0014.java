package com.xujinshan.leetcode.code0014;
/**
 * 0014-最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */

/**
 * 通过第一个字符串作为比较对象，让每个字符串与这个字符串的对应位置进行比较
 * 通过字符串自带的indexOf()函数进行判断
 */
class Solution01 {
    public String longestCommonPrefix(String[] strs) {
        // 如果字符串数组为空，或者字符串数组的长度为0， 则直接返回空字符串
        if (strs.length == 0 || strs == null) {
            return "";
        }
        // 保存字符串数组的第一个字符串
        String prefix = strs[0];
        // 循环遍历，从字符数串数组的第二个位置开始
        for (int i = 1; i < strs.length; i++) {
            // indexOf(String str) 返回指定字符串在字符串中第一次出现的索引，
            // 如果此字符串没有这样的字符串，返回-1
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // 第一个字符串长度到0 返回空字符串
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}

/**
 * 将第一个字符串作为比较对象，让该字符串的每个字符与其余字符串的对应位置比较
 */
class Solution02 {
    public String longestCommonPrefix(String[] strs) {
        // 字符串数组的长度为0 或者字符串数组为空，直接返回空字符串
        if (strs.length == 0 || strs == null) {
            return "";
        }
        // 遍历第一个字符串的每个字符
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            // 遍历每个字符串
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}

/**
 * 测试类
 */
public class Study0014 {
    public static void main(String[] args) {
        System.out.println(new Solution01().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
