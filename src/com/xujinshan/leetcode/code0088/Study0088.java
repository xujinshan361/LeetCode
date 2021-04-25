package com.xujinshan.leetcode.code0088;

import java.util.Arrays;

/**
 * 0088-合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明：
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 提示：
 * <p>
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 */

/**
 * 双指针从后往前移动
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 第一个数组最后一个元素下标
        int p1 = m - 1;
        // 第二个数组最后一个元素下标
        int p2 = n - 1;
        // 设置目标数组的元素放置索引
        int p = m + n - 1;

        // 当俩个数组有元素时候
        while ((p1 >= 0) && (p2 >= 0)){
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        // 添加剩余元素--只需要添加nums2 的原因是nums1 为源数组，如果剩余元素不需要进行重复添加
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}

/**
 * 测试
 */
public class Study0088 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Solution().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
