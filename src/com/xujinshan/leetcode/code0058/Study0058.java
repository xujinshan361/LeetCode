package com.xujinshan.leetcode.code0058;

/**
 * 0058-最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */

/**
 * 思路：
 * 从字符串末尾开始向前遍历，其中主要有俩种情况
 * 第一种，以字符串"hello World" 为例，从后向前遍历直到遍历到头或者遇到空为止，
 * 即为最后一个单词"world"的长度为5
 * 第二种，以字符串"hello world "为例，需要先过滤掉末尾的空格，再进行第一种
 */
class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        // 如果后位置索引小于0，表示没有符合要求的单词，直接返回0
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}

/**
 * 测试
 */
public class Study0058 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("hello world"));
    }
}
