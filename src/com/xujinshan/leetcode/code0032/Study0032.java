package com.xujinshan.leetcode.code0032;

/**
 * 0032-最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 动态规划
 */
class Solution01 {
    public int longestValidParentheses(String s) {
        // 保存最大结果
        int maxResult = 0;
        // 状态转移表
        int[] dp = new int[s.length()];
        // 填写状态转移表
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxResult = maxResult > dp[i] ? maxResult : dp[i];
            }
        }
        return maxResult;
    }
}

/**
 * 栈
 */

class Solution02 {
    public int longestValidParentheses(String s) {
        int maxResult = 0;
        /**
         * 当程序中需要使用 栈 这种数据结构是，推荐使用ArrayDeque，尽量避免使用 Stack,
         * 因为Stack 是古老的集合，性能较差
         *
         * 本程序中，使用到ArrayDeque 的方法：
         * push(E e) 栈顶添加一个元素
         * pop() 移除栈顶元素，如果栈顶没有元素抛出异常
         * peek()   取栈顶元素
         */
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxResult = maxResult > i - stack.peek() ? maxResult : i - stack.peek();
                }
            }
        }
        return maxResult;
    }
}

/**
 * 测试类
 */
public class Study0032 {
    public static void main(String[] args) {
        System.out.println(new Solution02().longestValidParentheses("(()"));
    }
}
