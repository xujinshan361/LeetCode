package com.xujinshan.offer.offer57_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer57_II 和为s 的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = sum(l, r);
            if (sum == target) {  // 数据合法，输出数据
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    res[i - l] = i;
                }
                result.add(res);
                l++;   // 更新左边指针
            } else if (sum < target) {
                r++;    // 更新右指针
            } else {
                l++;    // 更新左指针
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private int sum(int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += i;
        }
        return res;
    }
}

public class Offer57_II {
    public static void main(String[] args) {
        int[][] result = new Solution().findContinuousSequence(9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
