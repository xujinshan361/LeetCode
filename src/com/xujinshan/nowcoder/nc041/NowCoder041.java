package com.xujinshan.nowcoder.nc041;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xujinshan361@163.com
 * NowCoder041--最长无重复子串
 * 题目描述
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * 示例1
 * 输入
 * <p>
 * [2,3,4,5]
 * <p>
 * 返回值
 * <p>
 * 4
 * <p>
 * 示例2
 * 输入
 * <p>
 * [2,2,3,4,3]
 * <p>
 * 返回值
 * <p>
 * 3
 * <p>
 * 备注:
 * <p>
 * 1≤n≤10^5
 */

/**
 * 双重循环构建子串进行判断，牛客网运行超时，无法通过
 */
class Solution01 {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        int max = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (judge(arr, i, j) && max < j - i + 1) {
                    max = j - i + 1;
                }
            }
        }
        return max;
    }

    private boolean judge(int[] arr, int i, int j) {
        Set<Integer> set = new HashSet<>();
        for (int index = i; index <= j; index++) {
            if (set.contains(arr[index])) {
                return false;
            } else {
                set.add(arr[index]);
            }
        }
        return true;
    }

}

/**
 * HashMap解决
 */
class Solution02 {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int start = 0, end = 0; end < arr.length; end++) {
            if (map.containsKey(arr[end])) {
                // 重复了
                start = Math.max(start, map.get(arr[end]) + 1);
            }
            max = Math.max(max, end - start + 1);
            map.put(arr[end], end);
        }
        return max;
    }
}

public class NowCoder041 {
    public static void main(String[] args) {
        System.out.println(new Solution02().maxLength(new int[]{2, 3, 4, 5}));
    }
}
