package com.xujinshan.leetcode.code0012;

/**
 * 0012 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
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
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * <p>
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * <p>
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */

/**
 * 贪心算法
 */
class Solution {
    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        // 构建结果集字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 索引，遍历13种组合值
        int index = 0;
        while (index < 13) {
//            特别注意：这里是等号
//            while (num >= nums[index]) { // 这里使用循环，是同一种组合值，可能出现多次
//                // 注意：这里是等于号，表示尽量使用大的"面值"
//                // 找到符合要求的组合值，将其添加进字符串，并让源数字减少对应的值
//                stringBuilder.append(romans[index]);
//                num -= nums[index];
//            }
            /***
             * 与注释二选一即可，通过俩种不同的思路去考虑，注释为通过多次匹配同一个符号值
             * 下面的是通过直接取余，一次考虑，能匹配当前符号值的次数
             */
            // 当前符号值能匹配的最大次数
            int n = num / nums[index];
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    stringBuilder.append(romans[index]);
                }
            }
            // 去除当前符号值的多次匹配结果
            num %= nums[index];
            index++;
        }
        return stringBuilder.toString();
    }
}

/**
 * 测试类
 */
public class Study0012 {
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(1994));
    }
}
