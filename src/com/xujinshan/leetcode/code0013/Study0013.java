package com.xujinshan.leetcode.code0013;

import java.util.HashMap;
import java.util.Map;

/**
 * 0013-罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
 * 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */

/**
 * 保存俩位字符--通过判断加或者减来执行
 */
class Solution01 {
    public int romanToInt(String s) {
        // 保存结果
        int result = 0;
        // 保存前一个元素
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            // 保存当前元素
            int num = getValue(s.charAt(i));
            // 前面元素和当前元素进行比较
            if (preNum < num) {
                // 前面的元素小，则减
                result -= preNum;
            } else {
                // 前面的元素大，则加
                result += preNum;
            }
            preNum = num;
        }
        // 加上最后一个元素
        result += preNum;
        return result;
    }

    /**
     * 通过字符获取对应的值
     * @param ch
     * @return
     */
    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

/**
 * HashMap实现
 */
class Solution02 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("M", 1000);
        int result = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                // 向后移动俩个字符的情况
                result += map.get(s.substring(i, i + 2));
                i += 2;
            } else {  // 向后移动一个字符的情况
                result += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Study0013 {
    public static void main(String[] args) {
        System.out.println(new Solution01().romanToInt("LVIII"));
    }
}
