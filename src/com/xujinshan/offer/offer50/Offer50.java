package com.xujinshan.offer.offer50;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer50 -- 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 */
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (map.get(chars[i]) == 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}

public class Offer50 {
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("abaccdeff"));
    }
}
