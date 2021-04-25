package com.xujinshan.offer.offer29;

import java.util.Arrays;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer -- 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 *
 *     0 <= matrix.length <= 100
 *     0 <= matrix[i].length <= 100
 *
 */
class Solution{
    public int[] spiralOrder(int[][] matrix){
        // 边界条件
        if (matrix == null || matrix.length == 0|| matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows* columns;
        int row =0;
        int column = 0;
        int[] order = new int[total];
        for (int i = 0; i < total; i++) {
            if(row>=0&&row<rows &&column>=0&&column<columns&&visited[row][column]==false){
                order[i] = matrix[row][column];
                System.out.println(row +""+column);
                visited[row][column] = true;
            }
            if(row==0){
                column++;
            }
            if(row==rows-1){
                column--;
            }

            if(column ==0){
                row--;
            }
            if(column ==columns-1){
                row++;
            }
        }
        return order;
    }
}
public class Offer29 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
