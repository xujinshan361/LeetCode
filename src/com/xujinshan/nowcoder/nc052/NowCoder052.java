package com.xujinshan.nowcoder.nc052;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: xujinshan361@163.com
 * NowCoder052--括号序列
 * 题目描述
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，
 * 判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是
 * 合法的括号序列，但"(]"和"([)]"不合法。
 * 示例1
 * 输入
 * <p>
 * "["
 * <p>
 * 返回值
 * <p>
 * false
 * <p>
 * 示例2
 * 输入
 * <p>
 * "[]"
 * <p>
 * 返回值
 * <p>
 * true
 */
class Solution {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        char[] c = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                deque.push(c[i]);
            } else if (c[i] == ')') {
                // 在出栈的时候需要先判断栈中是否有内容，否则报空指针异常(例如字符串为"]")
                if (deque.isEmpty()) {
                    return false;
                }
                char ch = deque.pop();
                if (ch != '(') {
                    return false;
                }
            } else if (c[i] == ']') {
                if (deque.isEmpty()) {
                    return false;
                }
                char ch = deque.pop();
                if (ch != '[') {
                    return false;
                }
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                char ch = deque.pop();
                if (ch != '{') {
                    return false;
                }
            }
        }
        return deque.isEmpty() ? true : false;
    }
}

public class NowCoder052 {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("[]"));
    }
}
