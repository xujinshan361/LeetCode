package com.xujinshan.leetcode.code0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 0030-串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 */

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordNumber = words.length;
        if (wordNumber == 0) {
            return result;
        }
        int wordLenght = words[0].length();
        // HashMap1 存储所有单词
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String w : words) {
            /**
             * Map中的 default V getOrDefault(Object key, V defaultValue)
             * 当Map集合中有这个key时，就使用这个key，如果没有就使用默认的defaultvalue
             */
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        /**
         * 遍历所有的子串
         */
        for (int i = 0; i < s.length() - wordLenght * wordNumber + 1; i++) {
            // HashMap2 存储当前扫描的字符串包含的单词
            HashMap<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            // 判断子串是否符合
            while (num < wordNumber) {
                String word = s.substring(i + num * wordLenght, i + (num + 1) * wordLenght);
                // 判断该单词在HashMap1中
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    // 判断当前单词的 value 和 HashMap1中该单词的value
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            // 判断是不是所有的单词都符合条件
            if (num == wordNumber) {
                result.add(i);
            }
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Study0030 {
    public static void main(String[] args) {
        List<Integer> result = new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        for (int i : result) {
            System.out.print(i + "\t");
        }
    }
}
