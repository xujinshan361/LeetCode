package com.xujinshan.leetcode.code0039;

import java.util.*;

/**
 * 0039-组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 保存结果
        List<List<Integer>> result = new ArrayList<>();
        // 获取输入数组的长度
        int length = candidates.length;
        // 排序是为了提前终止搜索(剪枝操作)
        Arrays.sort(candidates);
        // 深度优先，回溯方法
        dfs(candidates, length, target, 0, new ArrayDeque<>(), result);
        return result;
    }

    /**
     * 回溯法(深度优先)
     *
     * @param candidates 数组输入
     * @param length     输入数组的长度
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根节点到任意节点的路径
     * @param result     结果集
     */
    private void dfs(int[] candidates, int length, int residue, int begin, Deque<Integer> path, List<List<Integer>> result) {
        if (residue == 0) {
            // 由于path 全局只使用一份，到叶子节点的时候需要保存结果
            result.add((new ArrayList<>(path)));
            return;
        }
        for (int i = begin; i < length; i++) {
            // 在数组有序的前提下，进行剪枝操作
            // 由于数组是排序好的，当前i的位置不满足添加，则后序的也不可能满足条件
            if (residue - candidates[i] < 0) {
                break;
            }
            // 满足条件，将该数字添加进path中
            path.addLast(candidates[i]);
            // 继续调用回溯函数，同时不修改搜索的起点下标，是为了解决数字可以重复的问题
            dfs(candidates, length, residue - candidates[i], i, path, result);
            // 回退
            path.removeLast();
        }
    }
}

public class Study0039 {
    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : result) {
            for (Integer number : list) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }
    }
}
