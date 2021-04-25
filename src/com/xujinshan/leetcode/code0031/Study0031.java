package com.xujinshan.leetcode.code0031;

import java.util.Arrays;

/**
 * 0031-下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到第一个不满足条件的a[i] 和a[i+1]对
        // 分析中使用a[i]和a[i-1]为了索引的方便性，采用a[i]和a[i+1]
        // 条件为 a[i]>=a[i+1]
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            // 找到a[j]的位置
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换a[i]和a[j]
            swap(nums, i, j);
        }
        // 将a[i+1]到末尾的元素逆置
        reverse(nums, i + 1);
    }

    /**
     * 数组元素逆置，从索引为start位置开始，末尾截止
     *
     * @param nums
     * @param start
     */
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    /**
     * 交换数组下标位置的俩个数值
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * 测试类
 */
public class Study0031 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
