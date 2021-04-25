package com.xujinshan.offer.offer06;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 06 -- 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 利用栈的特性
 */
class Solution01 {
    public int[] reversePrint(ListNode head) {
        // 创建栈
        Deque<Integer> deque = new ArrayDeque<>();
        // 将所有元素进入栈中
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        // 所有元素出栈，并填入数组中
        int size = deque.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = deque.pop();
        }
        return result;
    }
}

/**
 * 递归实现 -- 利用递归的自然特性
 */
class Solution02 {
    int[] result;  // 保存结果集合
    int size = 0;    //  保存数组的长度
    int index = 0;   // 数组填值所需要的索引

    public int[] reversePrint(ListNode head) {
        solve(head);
        return result;
    }

    // 定义递归函数
    public void solve(ListNode head) {
        if (head == null) {
            result = new int[size];
            return;
        }
        size++;     // 递归前进行size计算
        solve(head.next);
        result[index] = head.val;       // 递归后进行数组填数
        index++;
    }
}

public class Offer06 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(2)));
        System.out.println(Arrays.toString(new Solution02().reversePrint(head)));
    }
}
