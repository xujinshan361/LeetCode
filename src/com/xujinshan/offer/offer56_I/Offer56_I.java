package com.xujinshan.offer.offer56_I;

import java.util.*;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer56_I 数组中数字出现的次数I
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这
 * 两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 */

/**
 * 使用Set 效率低，leetcode可以通过
 */
class Solution01 {
    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        // 输出结果
        int[] result = new int[2];
        result[0] = (int) set.toArray()[0];
        result[1] = (int) set.toArray()[1];
        return result;
    }
}

/**
 * 异或操作：对于俩个操作数的每一位，相同结果为0，不同结果为1
 * 在计算的过程中，成对出现的数字的所有位会俩俩抵消为0，最终得到的结果
 * 就是个出现了一次的数字。
 * 如何扩展到找到俩个出现一次的数字？====》 把所有的数字分成俩组：
 *      俩个只出现一次的数字在不同的组中
 *      俩个相同的数字分到相同的组中
 * 假设 ：
 * 俩个只出现一次的数字为a和b，那么所有数字异或的结果就等于a和 b异或的结果，我们记为x。
 * 如果把x写成二进制形式 xk xk-1 ... x2 x1 x0 其中xi为0 或者1 ，当xi =1时候，表示ai和bi不相等
 * xi=0 表示ai和bi相对，任选一个xi不为0 ，按照第i为给原来的序列分组，如果该位为0就分到第一组，否则分到
 * 第二组，这样就可以满足条件了
 *
 * 首先，两个相同的数字的对应位都是相同的，所以一个被分到了某一组，另一个必然被分到这一组，所以满足了条件 2。
 * 这个方法在 xi=1的时候 a和 b 不被分在同一组，因为 xi=1 表示 ai 和 bi 不等，
 * 根据这个方法的定义「如果该位为 0就分到第一组，否则就分到第二组」可以知道它们被分进了两组，所以满足了条件 1。
 *
 */
class Solution02 {
    public int[] singleNumbers(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        // 从低位开始找，找到第一位为1的位置
        int div = 1;
        while ((div & result) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}

public class Offer56_I {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution02().singleNumbers(new int[]{4, 1, 4, 6})));
    }
}
