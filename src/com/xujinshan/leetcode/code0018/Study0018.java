package com.xujinshan.leetcode.code0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0018-四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素
 * a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /**
         * 获取数组长度
         */
        int length = nums.length;
        /**
         * 保存结果集
         */
        List<List<Integer>> result = new ArrayList<>();
        /**
         * 如果长度小于0.则没有符合条件的四个数
         */
        if (length < 4) {
            return result;
        }
        /**
         *  对数组排序，方便遍历和去重。
         */
        Arrays.sort(nums);
        /**
         * 当目标值比数组最小四个数和还小或者比数组最大四个数和还大，表示没有符合条件的四个数
         */
        if (target < nums[0] + nums[1] + nums[2] + nums[3]
                || target > nums[length - 1] + nums[length - 2] + nums[length - 3] + nums[length - 4]) {
            return result;
        }
        /**
         * 循环固定第一个数，然后循环遍历选择另外三个数
         */
        for (int i = 0; i < length - 3; i++) {
            /**
             * 相同的第一个数只固定一次，避免重复运算
             */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            /**
             * 如果target 小于当前循环能得到的最小和，则跳出循环
             * target小于当前最小值，则后面的状态不可能有符合条件的解，则直接break
             */
            if (target < nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) {
                break;
            }
            /**
             * 如果target 大于此轮循环的最大和，则继续循环下一个比较大的第一位数。
             * 随着i的增大，后面是有可能有符合条件的解，则直接continue
             */
            if (target > nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3]) {
                continue;
            }
            /**
             * 循环固定第二个数，根据双指针从它之后去选择另外俩个数
             */
            for (int j = i + 1; j < length - 2; j++) {
                /**
                 * 相同的第二个数只固定一次，避免重复运算
                 */
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                /**
                 * 如果target小于当前循环能得到的最小四数和，则跳出循环
                 * target小于当前循环的最小值，则后面的状态没有符合条件的解，直接break；
                 */
                if (target < nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) {
                    break;
                }
                /**
                 * 如果target大于此轮循环的最大和，则继续循环下一个比较大的第二位数
                 * 随着j的曾大，后面的状态可能会有满足条件的解，直接continue；
                 */
                if (target > nums[i] + nums[j] + nums[length - 1] + nums[length - 2]) {
                    continue;
                }
                /**
                 * 设置后俩个数的指针位置
                 */
                int L = j + 1, R = length - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    /**
                     * 根据四数之和与target大小的比较来移动俩指针
                     */
                    if (sum == target) {
                        // 满足条件，则加入result集合中
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        /**
                         * 同时移动 L，R，因为只移动L或者R，是不可能导致等于target的
                         */
                        L++;
                        // 去除L重复
                        while (L < R && nums[L - 1] == nums[L]) {
                            L++;
                        }
                        R--;
                        // 去除R重复
                        while (L < R && nums[R + 1] == nums[R]) {
                            R--;
                        }
                    } else if (sum > target) {
                        // 当前结果大于目标值，右边指针向左移动
                        R--;
                        // 去重复
                        while (L < R && nums[R + 1] == nums[R]) {
                            R--;
                        }
                    } else {
                        // 当前结果小于目标值，左边的指针向右移动
                        L++;
                        // 去重复
                        while (L < R && nums[L - 1] == nums[L]) {
                            L++;
                        }
                    }
                }
            }
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Study0018 {
    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
