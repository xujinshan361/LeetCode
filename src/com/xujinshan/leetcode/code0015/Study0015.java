package com.xujinshan.leetcode.code0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0015-三数之和
 * 给你一个包含 n个整数的数组 nums，判断nums 中是否存在三个元素 a，b，c，使得a+b+c=0？
 * 请你找出所有满足条件且不重复的三元组。
 * 注意：
 * 答案中不可以包含重复的三元组
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4],
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

/**
 * 排序+双指针
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 数组的长度
        int n = nums.length;
        // 将数组排序
        Arrays.sort(nums);
        // 保存结果集
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // 枚举a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次的枚举数不同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; ++second) {
                //需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                // 类似俩数之和问题
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Study0015 {
    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }
}
