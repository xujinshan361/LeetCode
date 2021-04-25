package com.xujinshan.leetcode.code0045;

/**
 * 0045-跳跃游戏II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 */

/**
 * 反向查找出发查找位置
 */
class Solution01{
    public int jump(int[] nums){
        // 初始化最后的位置
        int position = nums.length-1;
        // 初始化保存步长
        int steps = 0;
        // 外层循环保存每次跳转的位置索引
        while (position>0){
            // 内层循环，贪心寻找位置
            for(int i =0;i<position;++i){
                // 满足条件更新位置
                if(i+nums[i] >=position){
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}

/**
 * 正向查找可到达的最大位置
 */
class Solution02{
    public int jump(int[] nums){
        int length = nums.length;
        // 
        int end =0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0;i<length-1;i++){
            maxPosition=maxPosition>i+nums[i]?maxPosition:i+nums[i];
            if(i==end){
                end = maxPosition;
                steps ++;
            }
        }
        return steps;
    }
}
/**
 * 测试类
 */
public class Study0045 {
    public static void main(String[] args) {
        System.out.println(new Solution02().jump(new int[]{2,3,1,1,4}));
    }
}
