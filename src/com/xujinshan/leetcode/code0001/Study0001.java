package com.xujinshan.leetcode.code0001;
/**
 * 0001 两数之和
 * 给定一个整数数组 nums 和一个目标值 target， 请在该数组中找出和为目标值的俩个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用俩遍。
 * <p>
 * 示例：
 * 给定 nums = [2, 7, 11, 15],target = 9
 * 因为 nums[0] + nums[1] = 2 +7 = 9
 * 所以返回[0,1]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 暴力法
 * 遍历每个元素 x，并查找俩个值之和是否等于target
 * 分析：
 * 时间复杂度:O(n^2)
 * 空间复杂度：O(1)
 */
class Solution01 {
    public int[] twoSum(int[] sums, int target) {
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                // 满足条件，返回整形数组的结果
                if (sums[i] + sums[j] == target) {
                    int[] index = new int[2];
                    index[0] = i;
                    index[1] = j;
                    return index;
//                    return new int[]{i, j};
                }
            }
        }
        // 找不到符合条件的值，抛出异常
        throw new IllegalArgumentException("No two sum solution");
    }
}

/**
 * 俩遍哈希表
 * 时间复杂度:O(n)
 * 空间复杂度：O(n)
 */
class Solution02 {
    public int[] twoSum(int[] nums, int target) {
        // 创建HashMap
        Map<Integer, Integer> map = new HashMap<>();
        // 将所有的 nums 数值存放在map中，其中键为nums数组的值，值为 nums 数组的下标
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            // 循环遍历，计算nums 数组对应位置的值与目标值 target 之间的差值
            int index = target - nums[i];
            /**
             * boolean containsKey(Object key) 如果此映射包含指定键的映射关系返回true
             * 由于添加 map 时，使用数组的值作为key，可以通过判断差值 index 是否存在于 nums中
             * map.get(index ! =i)保证数组中同一个元素不能出现俩遍
             * 如果满足条件，返回解
             */
            if (map.containsKey(index) && map.get(index) != i) {
                return new int[]{i, map.get(index)};
            }
        }
        // 找不到符合条件的值，抛出异常
        throw new IllegalArgumentException("No two sum solution");
    }
}

/**
 * 一遍哈希表
 */
class solution03 {
    public int[] twoSum(int[] nums, int target) {
        // 创建map存储数据
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            /**
             * 将 solution02 改变，通过先判断，再添加元素进入map ，
             * 解决了同一个元素不能出现俩遍的情况
             */
            int index = target - nums[i];
            if (map.containsKey(index)) {
                return new int[]{map.get(index), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/**
 * 测试类
 */
public class Study0001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution02().twoSum(nums, target)));

    }
}

