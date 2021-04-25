package com.xujinshan.offer.offer42;

/**
 * 剑指 Offer 42 -- 连续数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 提示：
 *
 *     1 <= arr.length <= 10^5
 *     -100 <= arr[i] <= 100
 */
class Solution{
    public int maxSubArray(int[] nums){
        int pre = 0,maxAns = nums[0];
        for(int x:nums){
            // 状态转移方程 f(x) = max(f(x-1)+x,x)
            pre = Math.max(pre+x,x);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }
}

public class Offer42 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
