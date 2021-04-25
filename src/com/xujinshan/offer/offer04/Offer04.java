package com.xujinshan.offer.offer04;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 04 - 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的
 * 顺序排序，每一列都按照从上到下递增的顺序排序。请
 * 完成一个高效的函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 限制：
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 0 <= m <= 1000
 */


/**
 * 暴力解法
 */
class Solution01 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int [][] a= new int[4][5] ;
        int s = a.length;
        // 合法性判定
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * 线性查找
 * 由于给定的二维数组具备每行从左到右递增以及每列从上到下的特点，当访问到一个元素时，
 * 可以排除数组中的部分元素。
 * 从二维数组的右上角开始查找。如果当前的元素等于目标值，则返回true，如果当前的元素
 * 大于目标值，则移动到左边一列，如果当前元素小于目标值，则移动到下面一行。
 * <p>
 * 可以证明这种方式不会错过目标值。如果当前元素大于目标值，说明当前元素的下边的所有
 * 元素都一定大于目标值，因此往下查找不可能找到目标值，往左查找可能找到目标值。如果
 * 当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，因此往往查找不
 * 可能找到目标值，往下可能找道目标值。
 */
class Solution02 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 合法性判定
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0, column = columns - 1; //   从右上角第一个元素开始
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;     // 找到目标值，直接返回
            } else if (num < target) { // 比目标值小， 往下移动
                row++;
            } else {      // 比目标值大，往左移动
                column--;
            }
        }
        return false;
    }
}

public class Offer04 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new Solution02().findNumberIn2DArray(matrix, 5));
    }
}
