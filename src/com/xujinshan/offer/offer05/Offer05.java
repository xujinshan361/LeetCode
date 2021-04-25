package com.xujinshan.offer.offer05;

import java.sql.PreparedStatement;
import java.util.Arrays;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 05 - 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 */

/**
 * 字符数组
 * 有每次替换是从一个字符变成三个字符，使用字符数组可以方便地进行替换。建立字符数组地
 * 长度为s的长度的3倍，这样可保证字符数组可以容纳所有替换后的字符。
 *
 */
class Solution01 {
    public String replaceSpace(String s) {
        int length = s.length(); //  获取s的长度
        char[] array = new char[length * 3];  // 创建保存结果的数组
        int size = 0;           // 初始化为0 ，保存替换后数组的有效长度
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {   // 满足空格的字符，进行替换操作
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {  // 不满足的直接保存
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }
}

/**
 * 利用StringBuilder 的特性
 *
 */
class Solution02 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

public class Offer05 {
    public static void main(String[] args) {
        System.out.println(new Solution02().replaceSpace("We are happy."));
    }
}
