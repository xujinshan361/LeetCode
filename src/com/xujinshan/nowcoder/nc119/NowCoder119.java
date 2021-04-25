package com.xujinshan.nowcoder.nc119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: xujinshan361@163.com
 * NowCoder 119 -- 最小的k个数
 * 题目描述
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 * 示例1
 * 输入
 * <p>
 * [4,5,1,6,2,7,3,8],4
 * <p>
 * 返回值
 * <p>
 * [1,2,3,4]
 */

/**
 *  调用系统内置的排序函数，可以通过测试
 */
class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int length = input.length;
        if (length < k) {
            return new ArrayList<>();
        }
        Arrays.sort(input);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }
}

public class NowCoder119 {
    public static void main(String[] args) {
        List<Integer> result = new Solution().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        System.out.println(result);
    }
}
