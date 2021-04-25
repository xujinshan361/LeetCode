package com.xujinshan.offer.offer13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 13 -- 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人
 * 从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格
 * （不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */

/**
 * 深度优先搜索
 */
class Solution01 {
    int m, n, k; // 设置属性，m表示行数，n表示列数，k表示位数和最大值
    boolean[][] visited;    // 用于保存位置是否走过

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0);
    }

    /**
     * dfs
     *
     * @param i
     * @param j
     * @return
     */
    private int dfs(int i, int j) {
        // 索引不满足条件，位数和不满足条件，该位置已经被访问过，均返回0
        // 由于优化了俩个搜索方法，其中判断 i,j 小于0 的也可以去掉
        if (i < 0 || i >= m || j < 0 || j >= n || k < sums(i) + sums(j) || visited[i][j]) {
            return 0;
        }
        // 设置该位置已经被访问
        visited[i][j] = true;
        // 加一表示当前位置符合条件，同时向四个方向搜索
        // return 1+dfs(i+1,j)+dfs(i-1,j)+dfs(i,j+1)+dfs(i,j-1);
        // 这里可以优化，我们不需要向左和向上进行搜索，只需要向下和向右进行搜索
        // 向左向上为重复搜索
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);

    }

    // 计算位数和
    int sums(int x) {
        int s = 0;
        while (x != 0) {
            s = s + x % 10;
            x = x / 10;
        }
        return s;
    }
}

/**
 * 广度优先遍历
 */
class Solution02 {
    public int movingCount(int m, int n, int k) {
        // 位置是否被访问
        boolean[][] visited = new boolean[m][n];
        // 保存结果
        int result = 0;
        // 队列，其中 int[] 为位置的索引
        Queue<int[]> queue = new LinkedList<>();
        // 首先将 (0,0)添加进队列
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            // 取出队列中一个元素
            int[] x = queue.poll();
            // 获取行列索引
            int i = x[0], j = x[1];
            // 如果不满足条件，则直接跳出当前循环
            if (i >= m || j >= n || k < sums(i) + sums(j) || visited[i][j]) {
                continue;
            }
            // 满足条件，结果加一
            result++;
            visited[i][j] = true;
            // 优化搜索，只要搜索下和右两个方法，故判断条件中， 不需要判断i,j<0
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j + 1});
        }
        return result;
    }

    // 计算位数和
    int sums(int x) {
        int s = 0;
        while (x != 0) {
            s = s + x % 10;
            x = x / 10;
        }
        return s;
    }
}

public class Offer13 {
    public static void main(String[] args) {
        System.out.println(new Solution02().movingCount(2, 3, 1));
    }
}
