package com.xujinshan.nowcoder.nc073;

import java.util.Arrays;

/**
 * @Author: xujinshan361@163.com
 * NowCoder073--数组中出现次数超过一半的数字
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组
 * 中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 示例1
 * 复制
 * <p>
 * [1,2,3,2,2,2,5,4,2]
 * <p>
 * 返回值
 * <p>
 * 2
 */

class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        int res = array[array.length / 2];
        int count = 0;
        for (int i : array) {
            if (i == res) {
                count++;
            }
        }
        return count > array.length / 2 ? res : 0;
    }
}

public class NowCoder073 {
    public static void main(String[] args) {
        System.out.println(new Solution().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
