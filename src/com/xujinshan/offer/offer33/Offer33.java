package com.xujinshan.offer.offer33;


/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 33 -- 二叉搜索树后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * <p>
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i > j) {    // 说明此子树没有节点，返回true
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++; // 寻找以postorder[j] 为根的左子树区间
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++; // 寻找右区间
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}

public class Offer33 {
    public static void main(String[] args) {
        System.out.println(new Solution().verifyPostorder(new int[]{1,6,3,2,5}));
        Class<? extends Offer33> aClass = new Offer33().getClass();
        System.out.println(aClass.getClassLoader());
    }
}
