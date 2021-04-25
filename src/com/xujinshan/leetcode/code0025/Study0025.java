package com.xujinshan.leetcode.code0025;

/**
 * 0025-K个一组反转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 保存结果
        ListNode result = new ListNode(-1);
        result.next = head;
        // 待翻转链表的前驱和末尾
        ListNode pre = result;
        ListNode end = result;

        while (end.next != null) {
            // 移动end指针，找到需要翻转的部分
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果待翻转的部分，不足k个，直接返回
            if (end == null) {
                break;
            }
            // 保存需要翻转的开始节点
            ListNode start = pre.next;
            // 保存未翻转部分的开始节点
            ListNode next = end.next;
            end.next = null;
            // 执行翻转操作
            pre.next = reverse(start);
            // 初始化指针，执行下一次翻转操作
            start.next = next;
            pre = start;
            end = pre;
        }
        return result.next;
    }

    /**
     * 单链表翻转操作，(类似头插法建立单链表)
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        // 保存翻转后的结果
        ListNode pre = null;
        // 工作指针
        ListNode current = head;
        while (current != null) {
            // 保存待翻转的下一个节点
            ListNode next = current.next;
            // 将一个节点取下，插入到pre之后，类似于头插法建立单链表
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}

/**
 * 测试类
 */
public class Study0025 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4), new ListNode(5)};
        lists[0].next = lists[1];
        lists[1].next = lists[2];
        lists[2].next = lists[3];
        lists[3].next = lists[4];
        lists[4].next = null;

        ListNode result = new Solution().reverseKGroup(lists[0], 3);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}
