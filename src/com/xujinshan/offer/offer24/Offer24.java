package com.xujinshan.offer.offer24;

/**
 * @Author: xujinshan361@163.com
 * 剑指Offer24 -- 翻转链表
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
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

/**
 * 头插法建立单链表
 */
class Solution01 {
    public ListNode reverseList(ListNode head) {
        // 如果头节点为空，则直接返回
        if (head == null) {
            return null;
        }
        // 建立新链表的头节点，返回结果为 result.next
        ListNode result = new ListNode(0);
        // 工作指针
        ListNode p;
        while (head != null) {
            // 使用工作指针保存当前节点
            p = head;
            // 将head往后移动
            head = head.next;
            // 每次将p节点插入到result的后面，类似于头插入建立单链表
            p.next = result.next;
            result.next = p;

        }
        return result.next;
    }
}

/**
 * 双指针
 */
class Solution02 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = null; // 保存当前节点
        ListNode pre = head;   // 保存当前节点的下一个节点
        while (pre != null) {
            ListNode p = pre.next;
            pre.next = cur;     // 每次让俩个节点之间的指针逆向
            cur = pre;
            pre = p;
        }
        return cur;
    }
}

public class Offer24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        ListNode result = new Solution02().reverseList(head);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}
