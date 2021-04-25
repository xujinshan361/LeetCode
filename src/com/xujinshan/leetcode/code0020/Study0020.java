package com.xujinshan.leetcode.code0020;

import java.util.*;

/**
 * 0020-有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        /**
         * 当程序中需要使用 栈 这种数据结构是，推荐使用ArrayDeque，尽量避免使用 Stack,
         * 因为Stack 是古老的集合，性能较差
         *
         * 本程序中，使用到ArrayDeque 的方法：
         * push(E e) 栈顶添加一个元素
         * pop() 移除栈顶元素，如果栈顶没有元素抛出异常
         */
//        Stack<Character> stack =new Stack<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        /**
         * 遍历字符串的长度
         */
        for (int i = 0; i < s.length(); i++) {
            // 获取当前位置的字符
            char c = s.charAt(i);
            // 如果当前是右括号
            if (mappings.containsKey(c)) {
                // 在栈不为空的情况下，返回栈顶元素，如果为空，则返回一个不能被匹配的字符(例如'#')
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                // 查看当前元素与栈顶的元素是否匹配，不匹配则返回false
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // 如果是左括号，直接进栈
                stack.push(c);
            }
        }
        /**
         * 判断最后栈中是否有元素，如果有则匹配不成功
         */
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * 测试类
 */
public class Study0020 {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{[]}"));
    }
}
