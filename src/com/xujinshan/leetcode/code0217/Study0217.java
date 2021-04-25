package com.xujinshan.leetcode.code0217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 0217-存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */

/**
 * 排序解决
 */
class Solution01 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Hash 表
 */
class Solution02 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            // add() 添加一个元素，如果这个元素已经存在返回false
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * 测试
 */
public class Study0217 {
    public static void main(String[] args) {
        System.out.println(new Solution02().containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}

