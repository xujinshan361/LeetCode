package com.xujinshan.leetcode.code0038;

/**
 * 0038-外观数列
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 第一项是数字 1
 * <p>
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1
 * 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 */

/**
 * 利用循环，1->n 求解
 */
class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            // 新建一个StringBuilder用于拼接
            StringBuilder builder = new StringBuilder();
            // 取第一个字符
            char pre = str.charAt(0);
            // 统计有几个相同的
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    // 后一个字符与前一个字符相同
                    count++;
                } else {
                    // 拼接出 count 个 pre
                    builder.append(count).append(pre);
                    // 前缀等于不同处
                    pre = c;
                    count = 1;
                }
            }
            // 拼接 count 个 pre
            builder.append(count).append(pre);
            str = builder.toString();
        }
        return str;
    }
}

/**
 * 测试类
 */
public class Study0038 {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }
}
