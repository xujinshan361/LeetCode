package com.xujinshan.leetcode.code0034;

import java.util.Arrays;

/**
 * 0034-在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */

/**
 * 通过二分查找找到最左最右索引，时间复杂度为O(log n)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 返回的结果
        int[] targetRange = {-1, -1};
        int leftIndx = extremeInsertionIndex(nums, target, true);
        // 为找到匹配的关键字，直接返回
        if (leftIndx == nums.length || nums[leftIndx] != target) {
            return targetRange;
        }
        // 获取左边索引值
        targetRange[0] = leftIndx;
        // 获取右边索引值
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
        return targetRange;
    }

    /**
     * 返回最左或者最右索引，通过二分查找方式
     * @param nums      // 整形数组
     * @param target    // 待查找关键字
     * @param left      // boolean 值，true：最左索引，false：最右索引
     * @return
     */
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        // 左指针
        int low = 0;
        // 右指针
        int hight = nums.length;
        while (low < hight) {
            int mid = (hight + low) / 2;
            if (nums[mid] > target || left && target == nums[mid]) {
                // 索引可能在左半子区间，移动右指针
                hight = mid;
            } else {
                // 索引可能在右半子区间，移动左指针
                low = mid + 1;
            }
        }
        return low;
    }
}

/**
 * 测试类
 */
public class Study0034 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
