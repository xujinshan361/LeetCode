package com.xujinshan.nowcoder.nc105;

/**
 * @Author: xujinshan361@163.com
 * NowCoder105-- 二分查找
 * 题目描述
 * 请实现有重复数字的升序数组的二分查找
 * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 * 示例1
 * 输入
 * <p>
 * [1,2,4,4,5],4
 * <p>
 * 返回值
 * <p>
 * 2
 * <p>
 * 说明
 * <p>
 * 从左到右，查找到第1个为4的，下标为2，返回2
 * <p>
 * 示例2
 * 输入
 * <p>
 * [1,2,4,4,5],3
 * <p>
 * 返回值
 * <p>
 * -1
 * <p>
 * 示例3
 * 输入
 * <p>
 * [1,1,1,1,1],1
 * <p>
 * 返回值
 * <p>
 * 0
 */
class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 如果目标值存在返回下标，否则返回 -1
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // write code here
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
//            int mid = (right+left)/2;
            // 下面的方法解决左右指针直接相加导致整数越界
            int mid = right - (right - left) / 2;
            if (nums[mid] == target) {
                while (mid != 0 && nums[mid - 1] == target) {
                    mid = mid - 1;
                }
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}

public class NowCoder105 {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{1, 1, 2, 3, 7, 7, 7, 9, 9, 10}, 2));
    }
}
