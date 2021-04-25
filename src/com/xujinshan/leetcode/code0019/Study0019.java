package com.xujinshan.leetcode.code0019;

/**
 * 0019-删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第n个节点，并返回链表的头结点
 * <p>
 * 示例：
 * 给定一个链表：1->2->3->4->5 和n = 2
 * 当删除了倒数第二个节点后，链表变为:1->2->3->5
 * <p>
 * 说明：
 * 给定的n保证是有效的
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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 用于保存结果
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode first = result;
        ListNode second = result;
        /**
         * 第一个指针先走n步，然后第二个指针开始走
         */
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        /**
         * 第一个指针移动到最后，第二个指针则位于倒数第n位置
         */
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return result.next;
    }
}

/**
 * 测试类
 */
public class Study0019 {
    public static void main(String[] args) {
        ListNode[] list = new ListNode[]{new ListNode(1), new ListNode(2),
                new ListNode(3), new ListNode(4), new ListNode(5)};
        list[0].next = list[1];
        list[1].next = list[2];
        list[2].next = list[3];
        list[3].next = list[4];
        list[4].next = null;

        ListNode result = new Solution().removeNthFromEnd(list[0], 2);
        while (result != null) {
            System.out.print(result.val+"\t");
            result = result.next;
        }
    }
}
