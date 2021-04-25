package com.xujinshan.offer.offer12;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 12 -- 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一
 * 行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
 * word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 */

/**
 * 深度优先(DFS)+剪枝
 * 深度优先搜索：可以理解为暴力法遍历矩阵中所有字符串可能性。DFS通过递归，先朝着一个方向
 * 搜索到底，再回溯到上一个节点，沿另一个方向搜索，以此类推
 * 剪枝：在搜素中，遇到 这条路径不可能和目标字符串匹配成功的情况，(例如，此矩阵元素和目标
 * 字符不同、此元素已经被访问)，则应该立即返回，称之为可行性剪枝。
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * dfs
     * @param board 矩阵
     * @param word 查询单词的字符数组
     * @param i 当前元素在矩阵board 中行索引
     * @param j 当前元素在矩阵board 中列索引
     * @param k 当前目标字符在word中的索引
     * @return
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 行或者列索引越界，当前矩阵元素与目标字符不同或当前矩阵元素已经访问过
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        // 字符串已经全部匹配
        if (k == word.length - 1) {
            return true;
        }
        // 将该字符变成空，表示已经访问过
        board[i][j] = '\0';
        // 搜索下一个单元格，朝着当前元素的上下左右四个方向开始递归，找到一个符合条件即可
        boolean result = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        // 还原当前矩阵元素，将board[i][j]元素还原至初始值,即word[k]
        board[i][j] = word[k];
        return result;
    }
}

public class Offer12 {
    public static void main(String[] args) {
        char[][] boards = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Solution().exist(boards, "ABCCED"));
    }
}
