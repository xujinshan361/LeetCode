package com.xujinshan.leetcode.code0076;

import java.util.HashMap;
import java.util.Map;

/**
 * 0076-最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 */

class Solution {
    //TODO
    public String minWindow(String s, String t) {
        // 存储需要的子串t，其中键为字符，值为字符出现的频率
        Map<Character, Integer> need = new HashMap<>();
        // 存储窗口
        Map<Character, Integer> window = new HashMap<>();
        // 将字符串 s，t 转换成字符串数组，便于操作
        char[] cht = t.toCharArray();
        char[] chs = s.toCharArray();
        /*default V getOrDefault(Object key, V defaultValue)
         * 将返回指定键映射到的值，如果此映射不包含该键的映射，则返回defaultValue
         */
        // 将 cht 添加进need 中
        for (char c : cht) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 设置窗口的左右边界 [left,right) 为左开右闭区间
        int left = 0, right = 0;
        int valid = 0;      // 表示窗口中满足 need条件的字符个数 当valid == need.size()表示包含子串
        // 记录最小覆盖子串的起始索引及长度-- 初始化s长度加一
        int start = 0, length = s.length()+1;
        // 结束条件，右边界到达最右边
        while (right < chs.length) {
            // c 是将移入窗口的字符
            char c = chs[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的更新
            // need 中包含该字符
            if (need.containsKey(c)) {
                // 更新窗口中数据
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果窗口中该字符出现的次数刚好等于need中该字符的次数，更新valid
                if (window.get(c) == need.get(c)) {
                    valid++;
                }
            }
            // 判断左窗口是否要收缩-- 结束条件为valid == need.size() 即为valid 的最小值
            while (valid == need.size()) {
                // 这里更新最小覆盖子串
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                // d 是将移除窗口的字符
                char d = chs[left];
                // 左移窗口
                left++;

                // 进行窗口内数据的一系列更新
                // 如果need中包含该字符
                if (need.containsKey(d)) {
                    // 如果窗口中该字符出现的次数和need中该字符出现的次数相等，则valid--
                    if (window.get(d) == need.get(d)) {
                        valid--;
                    }
                    // 更新窗口中的数据
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回结果
        return length == s.length()+1 ? "" : s.substring(start, start + length);
    }
}

/**
 * 测试类
 */
public class Study0076 {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
