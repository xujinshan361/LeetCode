package com.xujinshan.leetcode.code0002;
/**
 * 0002 俩数相加
 * 给定俩个 非空 的链表用来表示俩个非负的整数。其中，它们各自的位数按照
 * 逆序 的方式存储的，并且它们的每一个结点只能存储  一位数字。
 * 如果，我们将这俩个数相加，则会返回一个新的俩表来表示它们的和、
 * 可以假设除了数字0以外，这俩个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) +(5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

/**
 * Definition for singly-linked list
 * 官方提供的结点结构，添加 ListNode(int x)为了创建方便
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 创建一个新的结果集链表，保存结果
 * 俩个链表对应位置相加，使用carry保存当前的进位
 */
class Solution {
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        // 新建headListNode 用于保存结果值
        ListNode headListNode = new ListNode(0);
        // 创建三个工作指针，用于移动
        ListNode p = L1, q = L2, result = headListNode;
        // 用于保存进位数值
        int carry = 0;
        // 当俩个链表都有一个不为空，则继续执行
        while (p != null || q != null) {
            // 去链表对应位置数值相加，同时加上低位的进位
            // (三目运算符用于判断结点是否为null，如果为null则赋值为0)
            int sum = carry + (p != null ? p.val : 0) + (q != null ? q.val : 0);
            // 取整保存当前位置的进位
            carry = sum / 10;
            // 取余保存当前位置的值
            result.next = new ListNode(sum % 10);
            // 移动结果集的工作指针
            result = result.next;
            // 链表不为空的情况下，移动工作指针
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {// 最后判断进位是否为0，不为0 ，则加入新节点保存作为高位
            result.next = new ListNode(carry);
        }
        // 从第二个节点返回(第一个节点创建时赋值为0)
        return headListNode.next;
    }
}

/**
 * 测试类
 */
public class Study0002 {
    public static void main(String[] args) {
        // 创建测试用例
        ListNode[] L1 = {new ListNode(2), new ListNode(4), new ListNode(3)};
        ListNode[] L2 = {new ListNode(5), new ListNode(6), new ListNode(4)};

        L1[0].next = L1[1];
        L1[1].next = L1[2];
        L1[2].next = null;

        L2[0].next = L2[1];
        L2[1].next = L2[2];
        L2[2].next = null;

        // 打印输出结果
        ListNode result = new Solution().addTwoNumbers(L1[0], L2[0]);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
