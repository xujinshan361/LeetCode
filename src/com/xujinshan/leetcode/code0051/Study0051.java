package com.xujinshan.leetcode.code0051;

import java.util.ArrayList;
import java.util.List;

/**
 * 0051-N 皇后问题
 * n皇后问题研究的是如何将n个皇后放置在 n*n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 提示：
 *
 *     皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */

class Solution {
    // TODO
    List<List<String >> result  = new ArrayList<List<String>>();
    /**
     * 输入棋盘长度n，返回所有合法的放置位置
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n){
        // '.' 表示为空,'Q'表示皇后，初始化空棋盘
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        backtrack(board,0);
        return result;
    }

    /**
     * 路径：board中小于 row 的那些行都已经成功放置了皇后
     * 选择列表：第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过 board 的最后一行
     * @param board
     * @param row
     */
    private void backtrack(List<String> board, int row){

        // 触发条件
        if(row == board.size()){
            System.out.println(row +":" +board.size());
            result.add(board);
            return;
        }
        int n = board.get(row).length();
        for(int col = 0;col<n;col++){
            // 排除不合法选择
            if(!isValid(board,row,col)){
                continue;
            }
            //做选择
//            StringBuilder sb = new StringBuilder(board.get(row));
//            sb.setCharAt(col,'Q');
//            board.set(col,sb.toString());
            swap(board,row,col,'Q');
            System.out.println(board + "hids "+row);
            backtrack(board,row+1);
            // 撤销操作
            swap(board,row,col,'.');
        }
    }
    // 修改List<String> 类型，在row，clo位置放入皇后
    private void swap(List<String> board,int row,int col,char ch){
        StringBuilder sb = new StringBuilder(board.get(row));
        sb.setCharAt(col,ch);
        board.set(row,sb.toString());
    }
    /**
     * 是否可以在 board[row][col] 放置皇后
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(List<String> board, int row, int col){
        int n = board.size();
         // 检查是否有皇后冲突--检查col这一列
        for (int i = 0; i < n; i++) {
            if(board.get(i).charAt(col)=='Q'){
                return false;
            }
        }
        //检查右上方是否有皇后冲突
        for(int i = row-1,j = col+1;i>=0&&j<n;i--,j++){
            if(board.get(i).charAt(j) =='Q'){
                return false;
            }
        }
        // 检查左上方是否有皇后相互冲突
        for(int i = row -1,j = col-1;i>=0&&j>=0;i--,j--){
            if(board.get(i).charAt(j)=='Q'){
                return false;
            }
        }
        return true;
    }
}
/**
 * 测试类
 */
public class Study0051 {
    public static void main(String[] args) {
       List<List<String>> result = new Solution().solveNQueens(4);
       for(List<String> list :result){
           System.out.println(list);
       }
    }
}
