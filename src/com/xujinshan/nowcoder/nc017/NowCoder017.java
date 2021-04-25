package com.xujinshan.nowcoder.nc017;


/**
 * @Author: xujinshan361@163.com
 * NowCoder017-最长回文子串
 * 题目描述
 *
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 *
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 * 示例1
 * 输入
 * 复制
 *
 * "abc1234321ab",12
 *
 * 返回值
 * 复制
 *
 * 7
 */

/**
 * 暴力解法
 */
class Solution01{
    public int getLongestPalindrome(String A,int n){
        int maxLen =0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                String cur = A.substring(i,j);
                if(isPalindrome(cur)&&cur.length()>maxLen){
                    maxLen = cur.length();
                }
            }
        }
        return maxLen;
    }
    private boolean isPalindrome(String s){
        int length = s.length();
        for (int i = 0; i < length/2; i++) {
            if(s.charAt(i)!=s.charAt(length-i-1)){
                return false;
            }
        }
        return true;
    }
}
class Solution02{
    public int getLongestPalindrome(String A, int n) {
        // 第 i 个字符到第 j 个字符是否是回文串
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        // 字符串首尾字母长度差 (d = j-i)
        for (int d = 0; d < n; d++) {
            // 字符串起始位置 i
            for (int i = 0; i < n-d; i++) {
                // 字符串结束位置 j
                int j = i+d;
                // 如果字符串 i 到 j 的首尾相等，再根据字符串 i-1 到 j-1 来确定，即得到递推公式
                if(A.charAt(i) == A.charAt(j)) {
                    if(d == 0 || d == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if(dp[i][j]) {
                        // 更新最大长度
                        max = Math.max(max, d+1);
                    }
                }
            }
        }
        return max;
    }
}
public class NowCoder017 {
    public static void main(String[] args) {
        System.out.println(new Solution02().getLongestPalindrome("abc1234321ab",12));
    }
}
