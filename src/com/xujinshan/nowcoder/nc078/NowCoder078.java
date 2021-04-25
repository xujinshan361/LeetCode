package com.xujinshan.nowcoder.nc078;

/**
 * @Author: xujinshan361@163.com
 * NowCoder 78 -- 反转链表
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 示例1
 * 输入
 * 复制
 * <p>
 * {1,2,3}
 * <p>
 * 返回值
 * 复制
 * <p>
 * {3,2,1}
 */
class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 该构造函数官方不提供，自己添加，纯属为了测试方便使用
     *
     * @param val
     * @param next
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return preNode;
    }
}
/**
 * 测试
 */
public class NowCoder078 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result = new Solution().ReverseList(head);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}
