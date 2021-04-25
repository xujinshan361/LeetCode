package com.xujinshan.offer.offer57;

import java.util.Arrays;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer 57 -- 和为s 的俩个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int pre = 0;
        int end = nums.length - 1;
        while (nums[pre] + nums[end] != target) {
            if (nums[pre] + nums[end] > target) {
                end--;
            }
            if (nums[pre] + nums[end] < target) {
                pre++;
            }
        }
        return new int[]{nums[pre], nums[end]};
    }
}

public class Offer57 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
