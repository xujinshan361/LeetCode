package com.xujinshan.leetcode.code0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0017-电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

class Solution {
    // 外面的{} 是一个匿名类，内层的{} 是表示的实例初始化块
    Map<String, String> phone = new HashMap<>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    // 保存结果
    List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // 数字字符串长度不等于0 ，则进行回溯
        if (digits.length() != 0) {
            // 刚开始已经产生的组合为空字符串
            backtrack("", digits);
        }
        return output;
    }

    /**
     * 回溯函数，将一个目前已经产生的组合combination 和接下来准备
     * 要输入的数字next_digits 作为参数
     *
     * @param combination
     * @param next_digits
     */
    private void backtrack(String combination, String next_digits) {
        // 没有更多的数字要检查
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {  // 还有数字要检查
            // 取下还有要检查的数字的第一位
            String digit = next_digits.substring(0, 1);
            // 获取该数字对应的字母
            String letters = phone.get(digit);
            // 对该数字对应的每个字母进行迭代
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }
}

/**
 * 测试类
 */
public class Study0017 {
    public static void main(String[] args) {
        List<String> list = new Solution().letterCombinations("23");
        for (String s : list) {
            System.out.print(s + "\t");
        }
    }
}
