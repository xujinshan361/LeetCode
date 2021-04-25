package com.xujinshan.leetcode.code0011;
/**
 * 0011-盛最多水的容器
 * 给你n个非负数a1，a2，...，an，每个数代表坐标中的一个点(i,ai)。在
 * 坐标内画n条垂直线，垂直线i的俩个端点分别是(i,ai)和(i,0)。找出其中的
 * 俩条线，使得与x轴共同构成的容器可以容纳最多的水。
 * 说明：
 * 不能倾斜容器，且n的值至少为2.
 * <p>
 * 示例：
 * 输入:[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */

/**
 * 暴力破解--列举所有的可能
 */
class Solution01 {
    public int maxArea(int[] height) {
        // 数组的长度
        int length = height.length;
        // 保存结果
        int result = 0;
        // 双重循环列举所有的可能结果
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                // 计算索引(索引从0开始)i，j对应位置的最大存储容量
                int currentResult = (j - i) * (height[j] > height[i] ? height[i] : height[j]);
                result = result > currentResult ? result : currentResult;
            }
        }
        return result;
    }
}

/**
 * 双指针法
 */
class Solution02 {
    public int maxArea(int[] height) {
        // 设置左右指针
        int left = 0, right = height.length - 1;
        // 保存结果
        int result = 0;
        while (left < right) {

            // 计算当前状态结果值
            int currentResult = (height[left] > height[right] ? height[right] : height[left]) * (right - left);
            result = result > currentResult ? result : currentResult;
            // 左右指针移动判断，哪个位置对应的高度值小则应移动哪一个
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Study0011 {
    public static void main(String[] args) {
        System.out.println(new Solution02().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
