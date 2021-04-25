package com.xujinshan.offer.offer21;

import java.util.Arrays;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 21 -- 调整数组顺序使得奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 *
 *     0 <= nums.length <= 50000
 *     1 <= nums[i] <= 10000
 */

/**
 * 双指针，i从索引0开始往后走，j从最后一个位置往前走，直到俩个相遇结束
 */
class Solution {
    public int[] exchange(int[] nums) {
        int i =0;
        int j = nums.length-1;
        while (i<=j){
            // i找到偶数
            if(nums[i]%2==1){
                i++;
                continue;
            }
            // j找到奇数
            if(nums[j]%2==0){
                j--;
                continue;
            }
            // 交换两个数
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
public class Offer21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{1,2,3,4})));
    }
}
