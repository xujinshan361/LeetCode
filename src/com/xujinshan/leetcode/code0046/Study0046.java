package com.xujinshan.leetcode.code0046;

import java.util.*;

/**
 * 0046-给定一个没有重复数字的序列，返回其所有可能的全排列
 * 示例：
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */

class Solution01 {
    // 保存结果集
    List<List<Integer>> result = new LinkedList<>();

    /**
     * 主函数，输入一组不重复的数字，返回全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        List<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return result;
    }

    /**
     * 选择条件：nums 中不存在 track 中
     * 结束条件：nums 中的元素全部在 track 中出现
     *
     * @param nums  输入的不重复数字
     * @param track 记录路径
     */
    private void backtrack(int[] nums, List<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择--删除最后一个进入的元素
            track.remove(track.size() - 1);
        }
    }
}

/**
 * 数字交换位置进行优化
 */
class Solution02 {
    /**
     * 主函数，输入一组不重复的数字，返回全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // 保存结果
        List<List<Integer>> result = new LinkedList<>();
        // 保存数字序列--将数字序列加入集合中，便于后续操作
        ArrayList<Integer> output = new ArrayList<>();
        // 将数字序列加入集合
        for (int num : nums) {
            output.add(num);
        }
        // 数字集合长度
        int n = nums.length;
        // 调用回溯函数
        backtrack(n, output, result, 0);
        return result;
    }

    /**
     * 回溯函数
     *
     * @param n      数字序列的长度
     * @param output 数字序列
     * @param result 结果集
     * @param first  回溯的位置索引，从0开始
     */
    private void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> result, int first) {
        // 所以数据都填完 --将数据添加进结果集合
        if (first == n) {
            result.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            // public static void swap(List<?> list, int i, int j)
            // Collections.swap() 交换i，j索引元素的位置2
            Collections.swap(output, first, i);
            // 继续递归填写下一个数
            backtrack(n, output, result, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}

public class Study0046 {
    public static void main(String[] args) {
        List<List<Integer>> result = new Solution01().permute(new int[]{1, 2, 3});
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}


