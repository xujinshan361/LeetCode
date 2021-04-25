package com.xujinshan.leetcode.code0067;

/**
 * 0067-二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
class Solution01 {
    public String addBinary(String a, String b) {
        // 将俩个字符串变成字符数组
        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();
        // 创建StringBuilder构建结果
        StringBuilder sb = new StringBuilder();
        // 获取俩个字符数组长度
        int i = cha.length - 1;
        int j = chb.length - 1;
        // 保存进位结果
        int temp = 0;
        // 保存每位相加的中间结果
        int cur;
        // 先计算相同长度的结果
        while (i >= 0 && j >= 0) {
            // 减 '0' 为了将字符变成数值
            cur = cha[i] - '0' + chb[j] - '0' + temp;
            // 更新进位操作
            temp = cur / 2;
            // 将末尾加入sb中
            sb.append(cur % 2);
            // 更新指针
            i--;
            j--;
        }
        // 当字符数组1 过长
        while (i >= 0) {
            cur = cha[i] - '0' + temp;
            temp = cur / 2;
            sb.append(cur % 2);
            i--;
        }
        // 当字符数组2过长
        while (j >= 0) {
            cur = chb[j] - '0' + temp;
            temp = cur / 2;
            sb.append(cur % 2);
            j--;
        }
        // 判断最后的进位是否有值
        if (temp != 0) {
            sb.append(1);
        }
        // 逆转
        sb.reverse();
        return sb.toString();
    }
}

/**
 * 简单优化，
 */
class Solution02 {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        if (carry > 0) {
            sb.append('1');
        }
        sb.reverse();

        return sb.toString();
    }
}

public class Study0067 {
    public static void main(String[] args) {
        System.out.println(new Solution02().addBinary("11", "1"));
    }
}
