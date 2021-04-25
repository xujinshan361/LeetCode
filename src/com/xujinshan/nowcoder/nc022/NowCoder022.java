package com.xujinshan.nowcoder.nc022;

import java.util.Arrays;

/**
 * @Author: xujinshan361@163.com
 * NowCoder 022-- 合并俩个有序的数组
 * 给出两个有序的整数数组A和 B，请将数组 B合并到数组 A中，变成一个有序的数组
 * 注意：
 * 可以假设 A数组有足够的空间存放 B数组的元素， A和 B中初始的元素数目分别为 m和n
 */
class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // A 数组足够大， 可以直接在A数组中操作，合并后需要的的A数组的有效长度为m+n
        int a = m - 1;
        int b = n - 1;
        int index = m + n - 1;
        while (a >= 0 && b >= 0) {
            A[index--] = A[a] > B[b] ? A[a--] : B[b--];
        }
        // 如果B还有元素，则需要添加进A中
        while (b >= 0) {
            A[index--] = B[b--];
        }
    }
}

public class NowCoder022 {
    public static void main(String[] args) {
        int[] A = new int[4];
        A[0] = 1;
        A[1] = 3;
        int[] B = {2, 4};
        new Solution().merge(A, 2, B, 2);
        System.out.println(Arrays.toString(A));
    }
}
