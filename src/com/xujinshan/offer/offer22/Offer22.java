package com.xujinshan.offer.offer22;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer 22 -- 链表中的倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;       // 前一级指针
        ListNode cur = head;       // 当前指针
        // 让pre 和cur 之间保持k个节点，当 cur到达最尾位置，则pre为倒数k个位置
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }
}

public class Offer22 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode result = new Solution().getKthFromEnd(head, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}

