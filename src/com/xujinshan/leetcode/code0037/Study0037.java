package com.xujinshan.leetcode.code0037;

/**
 * 0037-解数独
 * 编写一个程序，通过已填充的空格来解决数独问题
 * 一个数独的解法需要遵循如下规则：
 * 数字1-9在每一行只能出现一次
 * 数字1-9在每一列只能出现一次
 * 数字1-9在每个3*3的九宫格中只能出现一次
 */

class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    /**
     * 回溯函数
     *
     * @param board 数独存储字符数组
     * @param i     当前状态的行标
     * @param j     当前状态的列标
     * @return
     */
    private boolean backtrack(char[][] board, int i, int j) {
        // 定义并初始化行列索引最大值
        int rows = 9, columns = 9;
        if (j == columns) {
            // 穷举到最后一列的话就换到下一行重新开始
            return backtrack(board, i + 1, 0);
        }
        if (i == rows) {
            // 找到一个可行解，直接结束
            return true;
        }
        if (board[i][j] != '.') {
            // 如果有预设数字，不用穷举
            return backtrack(board, i, j + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳过去
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            // 回退
            board[i][j] = '.';
        }
        // 穷举玩 1-9 没有找打可行解，此路不通
        return false;
    }

    /**
     * 判断当前位置是否可以添加 number数字
     *
     * @param board
     * @param row    行标
     * @param column 列标
     * @param number 待填入数字
     * @return
     */
    private boolean isValid(char[][] board, int row, int column, char number) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[row][i] == number) {
                return false;
            }
            // 判断列是否存在重复
            if (board[i][column] == number) {
                return false;
            }
            // 判断3*3 小九宫格是否存在重复
            if (board[(row / 3) * 3 + i / 3][(column / 3) * 3 + i % 3] == number) {
                return false;
            }
        }
        return true;
    }
}

/**
 * 测试类
 */
public class Study0037 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
