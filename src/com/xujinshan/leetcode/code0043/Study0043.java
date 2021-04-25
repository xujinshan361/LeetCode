package com.xujinshan.leetcode.code0043;

/**
 * 0043-字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
 * 它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

class Solution {
    public String multiply(String num1, String num2) {
        // 排除特殊情况，直接返回结果
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存结果
        String result = "0";
        // 获取俩个乘数的长度
        int m = num1.length(), n = num2.length();
        /**
         * 遍历乘数num2 的每一位
         */
        for (int i = n - 1; i >= 0; i--) {
            // 保存乘数num2 当前位于被乘数num1 相乘的结果
            StringBuilder current = new StringBuilder();
            // 保存进位
            int add = 0;
            // 末尾补 0
            for (int j = n - 1; j > i; j--) {
                current.append(0);
            }
            // 获取乘数当前位的值
            int y = num2.charAt(i) - '0';
            // 遍历被乘数，将被乘数的每一位与乘数的当前位进行相乘
            for (int j = m - 1; j >= 0; j--) {
                // 获取被乘数当前位的值
                int x = num1.charAt(j) - '0';
                // 计算被乘数当前位于乘数当前位的乘积结果(加上来自低位的进位)
                int product = x * y + add;
                // 将各位加入结果
                current.append(product % 10);
                // 高位保留进位
                add = product / 10;
            }
            // 如果进位不为0 ，加入
            if (add != 0) {
                current.append(add % 10);
            }
            /**
             * 由于加入字符的顺序与计算原来的顺序相反，需要翻转字符串
             */
            result = addString(result, current.reverse().toString());
        }
        return result;
    }

    /**
     * 将俩个字符串结果相加返回
     *
     * @param num1 字符串1
     * @param num2 字符串2
     * @return
     */
    private String addString(String num1, String num2) {
        // 获取俩个字符串的长度
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        // 构建结果集
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            // 当俩个加数位数不匹配的时候，高位补0
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int current = x + y + add;
            // 计算结果，低位加入结果中
            result.append(current % 10);
            // 高位保留进位
            add = current / 10;
            i--;
            j--;
        }
        // 由于加入顺序与实际顺序相反，需要翻转操作
        result.reverse();
        return result.toString();
    }
}

public class Study0043 {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "456"));
    }
}
