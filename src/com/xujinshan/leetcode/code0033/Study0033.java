package com.xujinshan.leetcode.code0033;

/**
 * 0033-搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */

/**
 * 二分查找
 */
class Solution {
    public int search(int[] nums, int target) {
        // 获取数组的总长度
        int length = nums.length;
        // 如果数组为空，或者长度为0，直接返回
        if (nums == null || length == 0) {
            return -1;
        }
        // 如果数组长度为1，直接比较返回即可
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // 设置左右边界
        int left = 0, right = length - 1;
        /**
         * 二分查找
         */
        while (left <= right) {
            // 取中间位置值
            int mid = (left + right) / 2;
            // 如果中间位置的值符合查找条件，直接返回
            if (nums[mid] == target) {
                return mid;
            }
            // 左半部分有序
            if (nums[left] <= nums[mid]) {
                // target 可能在左半部分，移动右边指针，舍去右半部分
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {// target 不可能在左半部分，移动左边指针，舍去左半部分
                    left = mid + 1;
                }
            } else { // 右半部分有序
                // target 可能在右半部分，移动左指针，舍去左半部分
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {  // target 不可能在右半部分，移动右指针，舍去右半部分
                    right = mid - 1;
                }
            }
        }
        // 没找到，返回
        return -1;
    }
}

/**
 * 测试类
 */
public class Study0033 {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
