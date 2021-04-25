package com.xujinshan.nowcoder.nc065;

/**
 * @Author: xujinshan361@163.com
 * NowCoder065--斐波那契数列
 */
class Solution {
    public int Fibonacci(int n) {
        if(n ==0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
public class NowCoder065 {
    public static void main(String[] args) {
        System.out.println(new Solution().Fibonacci(4));
    }
}
