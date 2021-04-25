package com.xujinshan.offer.offer53_I;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer 53_I 在排序数组中查找数字I
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 */
class Solution {
    public int search(int[] nums, int target){
        int length = nums.length;
        int result =0;
        for (int i = 0; i < length; i++) {
            if(nums[i] ==target){
                result++;
            }
            if(nums[i] >target){
                break;
            }
        }
        return result;
    }
}
public class Offer53_I {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[] {5,7,7,8,8,10},8));
    }
}
