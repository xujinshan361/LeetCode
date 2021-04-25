package com.xujinshan.leetcode.code0016;

import java.util.Arrays;

/**
 * 0016-最近的三数之和
 * 给定一个包括n个整数的数组nums和一个目标值 target 。找出nums中的三个整数，使得
 * 它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */

/**
 * 双指针法
 */
class Solution01 {
    public int threeSumClosest(int[] nums, int target) {
        // 对数组元素进行排序
        Arrays.sort(nums);
        // 初始化用于保存结果的值
        int result = nums[0] + nums[1] + nums[2];
        // 利用下标i对数组进行遍历
        for (int i = 0; i < nums.length - 2; i++) {
            // 每次遍历过程中，设置俩个指针
            int left = i + 1;
            int right = nums.length - 1;
            // 俩个指针相遇，则循环结束
            while (left != right) {
                // 计算三个数之和
                int sum = nums[i] + nums[left] + nums[right];
                // 当前状态与target距离小于已经保存的最优状态，则更新result
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                // 如果当前值大于目标值则右边指针左移
                if (sum > target) {
                    right--;
                } else {// 如果当前值小于目标值则左指针右移
                    left++;
                }
            }
        }
        return result;
    }
}

/**
 * 双指针法的优化
 * 元素重复的问题
 */
class Solution02 {
    public int threeSumClosest(int[] nums, int target) {
        // 数组元素排序
        Arrays.sort(nums);
        // 初始化用于保存最终的结果
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    right--;
                    // 解决nums[right]重复
                    while (left != right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    // 解决nums[left]重复
                    while (left != right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
            // 解决nums[i]重复
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}

/**
 * 双指针优化
 * 解决超越界限的问题
 */
class Solution03 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                // 判断最小值
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(result - target) > Math.abs(min - target)) {
                        result = min;
                    }
                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(result - target) > Math.abs(max - target)) {
                        result = max;
                    }
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    right--;
                    while (left != right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left != right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }
}

/**
 * 解决三数之和等于target的问题
 */
class Solution04 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(result - target) > Math.abs(min - target))
                        result = min;
                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(result - target) > Math.abs(max - target))
                        result = max;
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                // 判断三数之和是否等于target
                if (sum == target)
                    return sum;
                if (Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
                if (sum > target) {
                    right--;
                    while (left != right && nums[right] == nums[right + 1])
                        right--;
                } else {
                    left++;
                    while (left != right && nums[left] == nums[left - 1])
                        left++;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Study0016 {
    public static void main(String[] args) {

    }
}
