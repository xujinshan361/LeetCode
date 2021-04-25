package com.xujinshan.leetcode.code0006;

import java.util.ArrayList;
import java.util.List;

/**
 * 0006-Z 字形变换
 * 将一个给定字符根据给定的行数，从上往下，从左往右进行Z字形排列。
 * 比如输入字符为"LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例1：
 * 输入：s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例2：
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */

class Solution {
    public String convert(String s, int numRows) {
        // 如果最终只有一行，则原字符串输出
        if (numRows == 1) {
            return s;
        }
        // 最终输出的行数由指定行数和字符串长度决定
        // 如果字符串没有指定的行数大，则直接使用字符串的长度作为最终输出行
        int resultRows = Math.min(numRows, s.length());
        // 创建列表，保存每行的字符
        List<StringBuilder> resultBuilders = new ArrayList<>();
        // 每一行通过一个StringBuilder来描述
        for (int i = 0; i < resultRows; i++) {
            resultBuilders.add(new StringBuilder());
        }
        // 记录当前行和行号的变化规则
        int currentRow = 0;
        boolean changeDirection = Boolean.FALSE;
        for (char c : s.toCharArray()) {
            resultBuilders.get(currentRow).append(c);
            // 处于第一行或者最后一行，需要转换变化规则
            if (currentRow == 0 || currentRow == (resultRows - 1)) {
                // 改变方向
                changeDirection = !changeDirection;
            }
            // 根据行号的变化规则，行号加一或者减一
            currentRow += changeDirection ? 1 : -1;
        }
        // 最终结果平凑输出变换后的信息
        StringBuilder result = new StringBuilder();
        for (StringBuilder b : resultBuilders) {
            result.append(b);
        }
        return result.toString();
    }
}

/**
 * 测试类
 */
public class Study0006 {
    public static void main(String[] args) {
        System.out.println(new Solution().convert("LEETCODEISHIRING", 3));
    }
}
