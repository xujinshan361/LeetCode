package com.xujinshan.leetcode.code0083;

/**
 * 0083-删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

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

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // current 工作指针
        ListNode current = head;
        while (current != null && current.next != null) {
            // 重复元素，则跳过该节点
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                // 不是重复元素，则直接移动指针
                current = current.next;
            }
        }
        return head;
    }
}

public class Study0083 {
    public static void main(String[] args) {
        ListNode result = new Solution().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, null))));
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}
