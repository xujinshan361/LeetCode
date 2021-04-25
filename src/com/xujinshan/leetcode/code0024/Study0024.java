package com.xujinshan.leetcode.code0024;

/**
 * 0024-俩俩交换链表中的结点
 * 给定一个链表，俩俩交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */

/**
 * Definition for singly-linked list
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 递归
 */
class Solution01 {
    public ListNode swapPairs(ListNode head) {
        // 如果链表没有长度，或仅仅有一个节点之间返回，
        // 也是递归的出口
        if (head == null || head.next == null) {
            return head;
        }
        // 第一个节点
        ListNode firstNode = head;
        // 第二个节点
        ListNode secondNode = head.next;
        // 递归调用
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }
}

/**
 * 迭代
 */
class Solution02 {
    public ListNode swapPairs(ListNode head) {
        // 初始化result用于保存结果
        ListNode result = new ListNode(-1);
        result.next = head;
        // 记录节点A的前驱
        ListNode prevNode = result;
        while ((head != null) && (head.next != null)) {
            // 用来交换的节点
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            // 交换
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            // 初始化prevNode，用于下一次交换
            prevNode = firstNode;
            head = firstNode.next;
        }
        return result.next;
    }
}

/**
 * 测试类
 */
public class Study0024 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4)};
        lists[0].next = lists[1];
        lists[1].next = lists[2];
        lists[2].next = lists[3];
        lists[3].next = null;
        ListNode result = new Solution02().swapPairs(lists[0]);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }

    }
}
