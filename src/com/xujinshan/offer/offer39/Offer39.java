package com.xujinshan.offer.offer39;

import java.util.Arrays;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer 39 -- 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);      // 将数组排序，数组中点的数字一定是众数
        return nums[nums.length / 2];
    }
}

public class Offer39 {
    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
