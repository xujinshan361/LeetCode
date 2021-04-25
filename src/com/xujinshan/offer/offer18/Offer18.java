package com.xujinshan.offer.offer18;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 18 -- 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变
 * 为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变
 * 为 4 -> 5 -> 9.
 * <p>
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */

/**
 * Definition for singly-linked list;
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
 * 双指针法
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        // 如果第一个节点就是要删除的，进行特殊处理
        if (head.val == val) {
            return head.next;
        }
        // 双指针，保存当前节点和前一个节点
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        // 找到 cur.var = val;进行删除节点操作
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}

public class Offer18 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        ListNode result = new Solution().deleteNode(head, 9);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
