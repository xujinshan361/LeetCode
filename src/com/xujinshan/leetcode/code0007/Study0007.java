package com.xujinshan.leetcode.code0007;

/**
 * 0007-整数反转
 * 给定一个32位有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例1：
 * 输入：123
 * 输出：321
 * 示例2：
 * 输入：-123
 * 输出：-321
 * 示例3：
 * 输入：120
 * 输出：21
 * 注意：假设我们的环境只能存储得下32位的有符号整数，则其数值范围为[-2^31,2^31-1]。
 * 根据这个假设，如果反转后整数溢出，那么就返回0。
 */
class Solution {
    public int reverse(int x) {
        // 保存结果
        int result = 0;

        while (x != 0) {
            int pop = x % 10;   // 取出最后一位
            x /= 10;    // 去掉x的最后一位
            // 判断是否正向越界
            /// 7或8是因为最大值2的31次方是2147483648，最小值负2的31次方减一是-2147483647，这两个数值的个位数是7和8.
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // 判断是否负向越界
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            // 计算结果
            result = result * 10 + pop;
        }
        return result;
    }
}

/**
 * 测试类
 */
public class Study0007 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-123));
    }
}
