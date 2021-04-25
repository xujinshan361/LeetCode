package com.xujinshan.leetcode.code0121;

/**
 * 0121-买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

/**
 * 暴力法
 */

class Solution01 {
    public int maxProfit(int prices[]) {
        int length = prices.length;
        // 保存最大收益
        int profit = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int cur = prices[j] - prices[i];
                if (cur > profit) {
                    profit = cur;
                }
            }
        }
        return profit;
    }
}

/**
 * 动态规划
 * 首先遍历价格数组，将每一天的价格减去前一天的价格，构建一个利润数组 profit[] 记录每一天的利润遍历数组
 * 利用动态规划的思想，求利润数组的最大子数组的和，即为最大利润
 */
class Solution02 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] profit = new int[prices.length];
        profit[0] = 0;
        for (int i = 1; i < profit.length; i++) {
            profit[i] = prices[i] - prices[i - 1];
        }
        int pre = profit[0];
        int max = profit[0];
        for (int i = 1; i < profit.length; i++) {
            pre = Math.max(profit[i], pre + profit[i]);
            max = Math.max(max, pre);
        }
        return max > 0 ? max : 0;
    }
}

/**
 * 测试
 */
public class Study0121 {
    public static void main(String[] args) {
        System.out.println(new Solution02().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
