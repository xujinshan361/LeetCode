package com.xujinshan.offer.offer56_II;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer56_II 数组中出现的次数II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 */

/**
 * map 实现效率低
 */
class Solution01 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        Set<Integer> set = map.keySet();
        for (int n : set) {
            if (map.get(n) == 1) {
                return n;
            }
        }
        return -1;
    }
}

/**
 * 位运算
 */
class Solution02 {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] bitSumArray = new int[32];    // 用于记录 数组中所有数字 的 每一位的和
        for (int num : nums) {

            // 由高到低，遍历当前数字的每一位，
            // 若 当前位为1，则使bitSumArray数组的相应的单元的值+1
            int curBit = 1;
            for (int i = 31; i >= 0; i--) {
                if ((curBit & num) != 0) {
                    bitSumArray[i]++;
                }
                curBit <<= 1;
            }
        }
        //计算结果：
        // 遍历bitSumArray数组的每一位，取每一位和3取余的结果（肯定为0或1）
        // 并将其 加入到 结果result的适当位上
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += bitSumArray[i] % 3;
        }

        return result;
    }
}

public class Offer56_II {
    public static void main(String[] args) {
        System.out.println(new Solution02().singleNumber(new int[]{3, 4, 3, 3}));
    }
}
