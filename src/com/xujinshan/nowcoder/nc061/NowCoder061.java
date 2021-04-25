package com.xujinshan.nowcoder.nc061;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xujinshan361@163.com
 * NowCoder 061--俩数之和
 * 题目描述
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），
 * 需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 *
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 *
 * 示例1
 * 输入
 *
 * [3,2,4],6
 *
 * 返回值
 *
 * [2,3]
 */

class Solution01 {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                // 满足条件，返回整形数组的结果
                if(numbers[i] + numbers[j] == target) {
                    int[] index = new int[2];
                    index[0] = i+1;
                    index[1] = j+1;
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
 * 俩变哈希表
 */
class Solution02 {
    public int[] twoSum(int[] numbers, int target) {
        // 创建HashMap
        Map<Integer, Integer> map = new HashMap<>();
        // 将所有的 nums 数值存放在map中，其中键为nums数组的值，值为 nums 数组的下标
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            // 循环遍历，计算nums 数组对应位置的值与目标值 target 之间的差值
            int index = target - numbers[i];
            /**
             * boolean containsKey(Object key) 如果此映射包含指定键的映射关系返回true
             * 由于添加 map 时，使用数组的值作为key，可以通过判断差值 index 是否存在于 numbers中
             * map.get(index ! =i)保证数组中同一个元素不能出现俩遍
             * 如果满足条件，返回解
             */
            if (map.containsKey(index) && map.get(index) != i) {
                return new int[]{i+1, map.get(index)+1};
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
    public int[] twoSum(int[] numbers, int target) {
        // 创建map存储数据
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            /**
             * 将 solution02 改变，通过先判断，再添加元素进入map ，
             * 解决了同一个元素不能出现俩遍的情况
             */
            int index = target - numbers[i];
            if (map.containsKey(index)) {
                return new int[]{map.get(index)+1, i+1};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
public class NowCoder061 {
    public static void main(String[] args) {
        System.out.println(new Solution01().twoSum(new int[]{20, 70, 110, 150},90));
    }
}
