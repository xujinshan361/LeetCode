package com.xujinshan.offer.offer61;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer 61 -- 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 */
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int n : nums) {
            if(n ==0){  // 跳过大小王
                continue;
            }
            max = Math.max(max, n);
            min = Math.min(min, n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        // 注意，这里不能取等号，如果不存在大小王，取等号可能会出错[1,6,5,4,2]
        return max - min < 5 ? true : false;
    }
}

public class Offer61 {
    public static void main(String[] args) {
        System.out.println(new Solution().isStraight(new int[]{0 ,0 ,1, 2 ,5}));
    }
}
