package com.xujinshan.leetcode.code0021;

/**
 * 0021-合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

import java.sql.PreparedStatement;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 迭代方法
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 申请一个空的头结点，用于保存结果
        ListNode prehead = new ListNode(-1);
        // 申请一个工作指针，用于移动
        ListNode prev = prehead;
        // 当俩个链表都不为空，则执行操作
        while (l1 != null && l2 != null) {
            // l1对应的值小
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                // l2 对应的值小
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 当有一个链表没有遍历完，则直接添加进入结果即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}

/**
 * 测试类
 */
public class Study0021 {
    public static void main(String[] args) {
        // 测试用例链表1
        ListNode[] l1 = new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(4)};
        l1[0].next = l1[1];
        l1[1].next = l1[2];
        l1[2].next = null;
        // 测试用例链表2
        ListNode[] l2 = new ListNode[]{new ListNode(1), new ListNode(3), new ListNode(4)};
        l2[0].next = l2[1];
        l2[1].next = l2[2];
        l2[2].next = null;
        ListNode result = new Solution().mergeTwoLists(l1[0], l2[0]);
        // 输出结果
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}
