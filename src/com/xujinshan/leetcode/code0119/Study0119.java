package com.xujinshan.leetcode.code0119;

import java.util.ArrayList;
import java.util.List;

/**
 * 0119-杨辉三角II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */

/**
 * 題目要求使用 O(K)的空间复杂度，所以只能创建一个集合。我们知道第 i 行的第 j 个 数的值， 是
 * i-1  行当中j-1 和 j 值的和。由于只有一个集合，所以需要不断的覆盖，所以第 j 个数的值等于前一个
 * 值加上当前值的和。因为集合中的值是不断覆盖，所以获取到的前一个值并不是我们想要的（因为上次循环把
 * 覆盖了）
 *
 * 解决方法：
 * - 创建一个中间变量记录前一个值
 * - 逆序构造每一行
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                // 逆序构造每一行
                list.set(j, list.get(j - 1) + list.get(j));
            }
            list.add(1);
        }
        return list;
    }
}

/**
 * 测试
 */
public class Study0119 {
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(3));
    }
}
