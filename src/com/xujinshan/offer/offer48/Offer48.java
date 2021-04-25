package com.xujinshan.offer.offer48;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指Offer48 -- 最长不含重复字符的子字符串
 * 给定一个字符串，请找出其中不含重复字符的最长子串的长度
 * 示例1：
 * 输入:"abcabcbb"
 * 输出：3
 * 解释：因为无重复字符的最长子串是 "abc",所以其长度为3
 * 示例2：
 * 输入："bbbbb"
 * 输出：1
 * 解释：因为无重复字符的最长子串是"b",所以其长度为 1
 * 示例3：
 * 输入："pwwkew"
 * 输出：3
 * 解释：因为无重复字符的最长子串是"wke",所以其长度为3。
 * 注意：答案必须是子串的长度，"pwke" 是一个子序列，不是子串。
 */

/**
 * 滑动窗口法解决
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Set集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        // 右指针，初始化为-1，相当于在字符串的左边界的左侧，还没开始移动
        int rightK = -1;
        // 保存需要返回的结果(最长的无重复子串)
        int result = 0;
        // 通过循环，遍历所有的字符作为开始位置的最长子串
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {//表示set集合中有元素，才可以执删除前一个位置的元素
                // 删除前一个位置的元素，相当于移动滑动窗口的左指针
                set.remove(s.charAt(i - 1));
            }
            // 移动滑动窗口右指针的操作
            // 第一个条件判断，字符串是否还有长度，即，右指针移动操作是否合法
            // 第二个条件，判断右指针向右移动一位，该字符加入set中是否合法
            // boolean contains(Object o);判断该set中是否还有 o 元素，有则返回true，
            while (rightK + 1 < s.length() && !set.contains(s.charAt(rightK + 1))) {
                // 滑动窗口右指针移动，将该合法的元素加入set集合
                set.add(s.charAt(rightK + 1));
                rightK++;
            }
            //result最大值判定
            result = result > rightK - i + 1 ? result : rightK - i + 1;
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Offer48 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
