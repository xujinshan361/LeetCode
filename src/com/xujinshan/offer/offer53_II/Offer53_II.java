package com.xujinshan.offer.offer53_II;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer 53_II 0~n-1 中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 */
class Solution {
    public int missingNumber(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[i]!=i){
                return i;
            }
        }
        return length;
    }
}
public class Offer53_II {
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }
}
