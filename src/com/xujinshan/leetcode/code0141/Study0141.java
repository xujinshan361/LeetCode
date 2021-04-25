package com.xujinshan.leetcode.code0141;

/**
 * 0141-环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}

/**
 * 哈希表
 * 遍历所有的结点，每次遍历到一个节点是，判断该节点此前是否被访问过。
 * 具体：
 * 可以使用哈希表来存储所有已经访问过的节点。每次到达一个节点，如果该节点已经存在于哈希表汇总，
 * 则说明该链表是环形链表，否则就将该节点加入哈希表中。
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> result = new HashSet<>();
        while (head != null) {
            if (!result.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

/**
 * 测试
 */
public class Study0141 {
    public static void main(String[] args) {
        System.out.println(new Solution().hasCycle(new ListNode(1)));
    }
}
