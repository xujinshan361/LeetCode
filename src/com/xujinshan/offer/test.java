package com.xujinshan.offer;



/**
 * @Author: xujinshan361@163.com
 */
class Solution{
    public static int[] solution(int[]nums){
        int[] result  =new int[nums.length];
        long res = 1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            res = res*nums[i];
        }
        for (int i = 0; i < length; i++) {
            result[i] = (int)res/nums[i];
        }
        return result;
    }
}
public class test {
    public static void main(String[] args) {

    }

}
