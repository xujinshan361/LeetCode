package com.xujinshan.leetcode.code0042;

import java.util.ArrayDeque;

/**
 * 0042-接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */

class Solution {
    public int trap(int[] height) {
        // 初始化结果集，遍历索引
        int result = 0, current = 0;
        /**
         * ArrayDeque 来实现栈的操作
         * 栈中存储数组索引
         */
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // 遍历数组
        while (current < height.length) {
            /**
             * 栈不为空，且当前数组元素，比栈中保存的索引位置的元素的值大
             * 意味着栈中的元素可以被弹出
             */
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                // 弹出栈中元素
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                // 计算俩索引位置之间的距离
                int distance = current - stack.peek() - 1;
                // 计算装水的最大高度
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                result += distance * boundedHeight;
            }
            // 将当前的高度的索引添加进栈，并后移一位
            stack.push(current++);
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Study0042 {
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
