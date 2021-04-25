package com.xujinshan.nowcoder.nc059;

/**
 * @Author: xujinshan361@163.com
 * NowCoder059--矩阵的最小路径和
 * 题目描述
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 * 示例1
 * 输入
 * <p>
 * [[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]]
 * <p>
 * 返回值
 * <p>
 * 12
 * <p>
 * 备注:
 * <p>
 * 1<=n,m<=2000
 * 1<=arri,j<=100
 */

/**
 * 设置dp[n][m] 表示到达matrix[n][m]中对应位置的最小值
 * 第一行只能从左往右
 * 第一行的值为原数组的第一个元素dp[0][0=matrix[0][0]
 * dp[0][j] = matrix[0][j] + dp[0][j-1];
 * 第一列元素 只能从上往下
 * dp[i][0] = dp[i-1][0] + matrix[i][0]
 *
 * 第二行第二列元素的可能从 当前节点的左节点 和上节点过来
 * 那么该节点的最小值应为 当前节点的值 加上 min （ 上节点 左节点）
 * dp[i][j] = matrix[i][j] + Math.min(dp[i][j-1],dp[i-1][j]);
 *
 * 那么最后一个节点的值就为最小的路径和
 */
class Solution {
    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        // 初始化第一个数字
        dp[0][0] = matrix[0][0];
        // 填写第一列的数据，只能往下走
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        // 填写第一行数据，只能往右走
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        // 填写中间数据
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 通过判断往下或者往右，选择较小的走
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];
    }
}

public class NowCoder059 {
    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}}));
    }
}
