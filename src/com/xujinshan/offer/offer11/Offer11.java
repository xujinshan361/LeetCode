package com.xujinshan.offer.offer11;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 11 -- 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 */

/**
 * 暴力解法
 */
class Solution {
    public int minArray(int[] numbers) {
        // 获取数组长度
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            // 找到第一个 后一个元素比前一个小的，即为最小元素
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        // 没找到这样的元素，即数组没有旋转或者数组元素都相同，第一个元素为最小
        return numbers[0];
    }
}

public class Offer11 {
    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[]{3, 4, 5, 1, 2}));
    }
}
