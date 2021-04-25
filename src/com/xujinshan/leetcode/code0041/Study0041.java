package com.xujinshan.leetcode.code0041;

/**
 * 0041-缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * <p>
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        // 将数组中小于0的数修改为 nums.length+1
        for (int i = 0; i < length; ++i) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        // 将数组中元素所表示的索引位置(位于[1,length]之间的)数字变成负数
        for (int i = 0; i < length; ++i) {
            // 返回索引i位置的绝对值
            int number = nums[i] > 0 ? nums[i] : -nums[i];
            if (number <= length) {
                nums[number - 1] = -(nums[number - 1] > 0 ? nums[number - 1] : -nums[number - 1]);
            }
        }
        // 返回第一个值大于0 的下标加一
        for (int i = 0; i < length; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
}

/**
 * 测试类
 */
public class Study0041 {
    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
