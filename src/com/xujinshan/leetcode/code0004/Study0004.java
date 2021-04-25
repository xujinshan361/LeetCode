package com.xujinshan.leetcode.code0004;

/**
 * 0004 寻找俩个正序数组的中位值
 * 给定俩个大小为 m 和 n 的正序(从小到大)数组 nums1 和 nums2
 * 找出这俩个正序数组的中位数，并且要求算法的时间复杂度为O(log(m+n))
 * 可以假设 nums1 和 nums2 不会同时为空
 * <p>
 * 示例1：
 * nums1 = [1, 3]
 * nus2 = [2]
 * 则中位数是2.0
 * 示例2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是(2+3)/2 = 2.5
 */

/**
 * 二分查找法解决
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 获取俩个数组的长度
        int length1 = nums1.length, length2 = nums2.length;
        // 获取俩个数组的总长度
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            // 如果俩个数组的总长度为奇数
            int minIndex = totalLength / 2; //取中间位置
            double median = getKthElement(nums1, nums2, minIndex + 1);
            return median;
        } else {
            // 如果俩个数组的总长度为偶数
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;// 取中间俩个元素
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /**
         * 主要思路：
         * 要找到第k(k>1)小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1]进行比较
         * 其中 / 表示整数除法。
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我"删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        // 获取俩个数组的长度
        int length1 = nums1.length, length2 = nums2.length;
        // 设置左右移动指针
        int index1 = 0, index2 = 0;

        int kthElement = 0;
        while (true) {
            /**
             * 边界情况
             */
            // 第一个数组元素排除完，只剩余第二个数组
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            // 第二个数组元素排除完，只剩余第一个数组
            if (index2 == nums2.length) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                // k 为1 返回俩个数组首元素的最小值
                return Math.min(nums1[index1], nums2[index2]);
            }
            /**
             * 正常情况
             */
            // 取k的中间位置
            int half = k / 2;
            // 设置新的左右指针
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            // 取出左右指针对应的位置
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                // 左指针小，更新左边
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                // 又指针小，更新右边
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}

/**
 * 测试类
 */
public class Study0004 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3}, nums2 = new int[]{2};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
