package com.xujinshan.nowcoder.nc003;

/**
 * @Author: xujinshan361@163.com
 * NowCoder 003-- 链表中是否有环
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 * <p>
 * 说明：本题目包含复杂数据结构ListNode，
 */

import java.util.HashSet;
import java.util.Set;

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
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }
}

/**
 * 快慢指针
 */
class Solution02 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {//利用快慢指针找相遇点
                fast = head;
                while (fast != slow) {
                    slow = slow.next;//设置以相同速度的新指针从起始位置出发
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

public class NowCoder003 {
    public static void main(String[] args) {
        ListNode pre = new ListNode(3);
        ListNode cur = new ListNode(4);
        ListNode head = new ListNode(1, new ListNode(2, pre));
        pre.next = cur;
        cur.next = pre;
        System.out.println(new Solution().detectCycle(head));
    }
}
