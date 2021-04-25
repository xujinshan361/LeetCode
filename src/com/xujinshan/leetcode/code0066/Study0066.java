package com.xujinshan.leetcode.code0066;

/**
 * 0066-加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 *
 *     1 <= digits.length <= 100
 *     0 <= digits[i] <= 9
 *
 */

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * 加一
 */
class Solution{
    public int[] plusOne(int[] digits){
        if(digits.length == 0||digits==null){
            return digits;
        }
        int carry = 1;
        int length = digits.length;
        for (int i = length-1; i >= 0; i--) {
            int value = digits[i] +carry;
            digits[i] = value%10;
            carry = value/10;
        }
        if(carry !=0){
            int[] result = new int[length+1];
            result[0] = carry;
            for(int i =0;i<length;i++){
                result[i+1] =digits[i];
            }
            return result;
        }
        return digits;
    }
}

/**
 * 测试类
 */
public class Study0066 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{4,3,2,1})));
    }
}
