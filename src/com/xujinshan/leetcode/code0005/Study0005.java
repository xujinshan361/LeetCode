package com.xujinshan.leetcode.code0005;

/**
 * 0005-最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。可以假设s的最大长度为 1000。
 * 示例1:
 * 输入："babad"
 * 输出："bab"
 * 注意："aba"也是一个有效答案
 * 示例2：
 * 输入："cbbd"
 * 输出："bb"
 */

/**
 * 暴力破解
 * 时间复杂度:O(n^3)
 */
class Solution01 {
    public String longestPalindrome(String s) {
        // 获取当前字符串的长度
        int length = s.length();
        // 如果当前字符的长度小于 2 ，则必为回文串，直接返回
        if (length < 2) {
            return s;
        }
        // 保存返回字符串的信息
        int maxLenght = 1;   // 返回字符串的最大长度
        int begin = 0;      // 返回字符串的开始位置
        //将字符串变成字符数组
        char[] charArray = s.toCharArray();
        // 枚举所有长度严格大于1的子串
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length; j++) {
                // 判断索引i,j(包括i,j)之间位置是否符合回文串特征
                if (j - i + 1 > maxLenght && validPalindromic(charArray, i, j)) {
                    // 满足条件，则更新返回字符串信息
                    maxLenght = j - i + 1;
                    begin = i;
                }
            }
        }
        // 返回字符串
        return s.substring(begin, begin + maxLenght);
    }

    /**
     * 验证子串 charArray[left...right]是否为回文串
     * @param charArray 串
     * @param left  起始索引
     * @param right  终止索引
     * @return
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {  // 不满足条件退出
            // 比较对应位置字符是否相同
            if (charArray[left] != charArray[right]) {
                // 不相同，则返回false
                return false;
            }
            // 判断下一个位置
            left++;     // 左边索引向右移动
            right--;    // 右边索引向左移动
        }
        return true;
    }
}

/**
 * 中心扩散法
 * 时间复杂度:O(n^2)
 */
class Solution02 {
    public String longestPalindrome(String s) {
        // 获取当前字符串的长度
        int length = s.length();
        // 如果字符串的长度小于 2 ，则必为回文串，直接返回
        if (length < 2) {
            return s;
        }
        // 用于保存需要返回的字符串的信息
        int maxLength = 1;   // 返回字符串的最大长度
        int begin = 0;      // 返回字符串的起始索引
        // 将字符串变成字符数组，方便操作
        char[] charArray = s.toCharArray();
        // 遍历所有可能的字符中心
        for (int i = 0; i < length - 1; i++) {
            // 奇数字符中心
            int oddLength = expandArroundCenter(charArray, i, i);
            // 偶数字符中心
            int evenlengt = expandArroundCenter(charArray, i, i + 1);
            // 当前最大长度(比较奇数和偶数，取出最大的)
            int curMaxLength = Math.max(oddLength, evenlengt);
            // 如果当前值大于最大值，则更新最大值
            if (curMaxLength > maxLength) {
                maxLength = curMaxLength;
                // 计算开始索引，需要计算
                begin = i - (maxLength - 1) / 2;
            }
        }
        // 返回满足条件的字符序列
        return s.substring(begin, begin + maxLength);
    }

    /**
     * 中心扩散，判断子串是否符合条件
     * @param charArray 字符串
     * @param left  中心(左边)索引
     * @param right 中心(右边)索引
     * @return
     */

    private int expandArroundCenter(char[] charArray, int left, int right) {
        // 当 left = right 的时候，回文中心是一个字符，回文串的长度是奇数
        // 当 left = ringht-1 的时候，回文中心是俩个字符，回文串的长度是偶数
        int len = charArray.length;
        int i = left;       // 保存左边索引
        int j = right;      // 保存右边索引
        while (i >= 0 && j < len) {     // 索引不满足条件，退出
            if (charArray[i] == charArray[j]) {     //  满足回文的条件
                i--;    // 左边索引向左移动
                j++;    // 右边索引向右移动
            } else {
                break;      // 不满足条件退出
            }
        }
        // 跳出while循环时，恰好满足s.charAt(i)!=s.charAt(j)
        // 回文串的长度是 j -i + 1 - 2 = j - i + 1
        return j - i - 1;
    }
}

/**
 * 动态规划
 * 时间复杂度：O(n^2)
 */
class Solution03 {
    public String longestPalindrome(String s) {
        // 读取字符串的长度
        int length = s.length();
        // 如果字符串的长度小于2，则必为回文串，直接返回
        if (length < 2) {
            return s;
        }
        // 保存返回字符串的信息
        int maxLength = 1;      // 返回字符串的最大长度
        int begin = 0;      // 返回字符串的开始位置
        // dp[i][j] 表示s[i...j]是否是回文串
        boolean[][] dp = new boolean[length][length];
        // 初始化动态规划表，对脚线位置标示字符串只有一个元素，必为回文串，填true
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        // 将字符串变成字符数组
        char[] charArray = s.toCharArray();
        // 双重循环，填写动态规划表
        // 需要先填左下角
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) { // i和j不相等，则不是回文串
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {  // 除去i和j相等，判断条件中间只有一个元素了，必然为回文串
                        dp[i][j] = true;
                    } else {
                        // 状态转移方程
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要dp[i][j] == true 成立，就标示子串s[i...j]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }
}

/**
 * 测试类
 */
public class Study0005 {
    public static void main(String[] args) {
        System.out.println(new Solution03().longestPalindrome("ababd"));
    }
}
