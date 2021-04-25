package com.xujinshan.offer.offer31;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer31 -- 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * 提示：
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 */

/**
 * 添加一个辅助栈
 * 借用一个辅助栈，模拟压入、弹出操作
 * 入栈操作：按照压栈序列的顺序执行
 * 出栈操作：每次入栈后，循环判断"栈顶元素==弹出序列的当前元素"是否成立，将符合
 * 弹出序列顺序的栈顶元素全部弹出
 * 注意：该题中不考虑元素重复问题
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 添加一个辅助栈
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        for (int nums : pushed) {
            deque.push(nums);
            while (!deque.isEmpty() && deque.peek() == popped[i]) {
                deque.pop();
                i++;
            }
        }
        return deque.isEmpty();
    }
}

public class Offer31 {
    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}));
    }
}
