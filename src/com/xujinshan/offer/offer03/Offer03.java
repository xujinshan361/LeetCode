package com.xujinshan.offer.offer03;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 03 - 数组中重复的数字
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 */

/**
 * 利用set集合的特性，元素唯一，来解决
 */
class Solution01 {
    public int findRepeatNumber(int[] nums) {
        // 利用set的特性来解决
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        // 返回一个不在 0~n-1的范围内数字表示没找该特性的数字
        return -1;
    }
}

/**
 * 原地置换
 * 该方法主要用于重复出现的数，原地置换的思路为，我们将指针对应的元素放置到属于他的位置
 * (索引对应的位置)。可以这样理解：每个人都有自己的位置，需要和别人调换回到自己的位置，
 * 调换之后，发现我们的位置上有人了，则返回。
 */
class Solution02 {
    public int findRepeatNumber(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 发现重复元素
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 置换，将指针下的元素换到属于他的索引位置
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}

public class Offer03 {
    public static void main(String[] args) {
        System.out.println(new Solution02().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
