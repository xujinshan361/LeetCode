package com.xujinshan.leetcode.code0022;

/**
 * 0022-括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合
 * <p>
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力解法
 */
class Solution01 {
    public List<String> generateParenthesis(int n) {
        // 保存结果
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

    /**
     * 暴力破解，列举所有可能的解，再进行判断
     * @param current
     * @param pos
     * @param result
     */
    private void generateAll(char[] current, int pos, List<String> result) {
        // 长度符合要求
        if (pos == current.length) {
            if (valid(current)) {
                // 满足有效括号，则添加进结果集
                result.add(new String(current));
            }
        } else {
            // 长度不符合要求，则继续进行括号填充
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    /**
     * 计算该字符数组是否符合有效括号
     * @param current
     * @return
     */
    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }
}

/**
 * 回溯法(深度优先遍历)
 */
class Solution02 {
    public List<String> generateParenthesis(int n) {
        // 保存结果
        List<String> result = new ArrayList<>();
        // 调用回溯函数
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     * 回溯函数 - 如果左括号的数量不大于n，可以放一个左括号，
     * 如果右括号的数量小于左括号的数量，可以放一个右括号
     * @param result    保存结果
     * @param current   构建当前状态的字符串
     * @param open      左括号的个数
     * @param close     右括号的个数
     * @param max       字符串的最大长度
     */
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // 满足最终的条件，保存结果
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}


/**
 * 测试类
 */
public class Study0022 {
    public static void main(String[] args) {
        List<String> result = new Solution02().generateParenthesis(3);
        for (String s : result) {
            System.out.print(s + "\t");
        }
    }
}
