package com.xujinshan.leetcode.code0023;

/**
 * 0023 合并k个排序链表，返回合并后的排序链表，请分析和描述算法的复杂度
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 顺序合并
 * 用一个变量 result 来维护以及合并的链表，第 i 次循环把 i 个链表和 result 合并，
 * 答案保存到 result 中
 */
class Solution01 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 链表为空，或者长度为0直接返回
        if (lists == null || lists.length == 0) {
            return null;
        }
        //将lists[0]作为最终合并的链表，然后将list[0]和lists[1]合并成lists[0-1]
        //再将lists[0-1]和lists[2]合并，如此反复最终lists[0]就是最终结果
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }
        return result;
    }

    /**
     * 合并两个有序链表
     */
    private ListNode merge(ListNode a, ListNode b) {
        // 有一个为空，则直接返回另一个
        if (a == null || b == null) {
            return (a == null) ? b : a;
        }
        // 递归调用
        if (a.val <= b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }
}

/**
 * 利用堆做排序--优先级队列
 */
class Solution02 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        /**
         * 创建一个堆，并设置元素的排序方式
         * PriorityQueue 通过二叉小顶堆实现的，可以用一棵完全二叉树表示
         * PriorityQueue 优先级队列
         * 优先级队列的作用是能保证每次取出的元素都是队列中权值最小的
         * 权值的大小的评判可以通过元素本身的自然顺序，也可以通过构造时传入的比较器Comparator(程序中使用)
         */
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });

        // 遍历链表数组，然后将每个链表的每个节点都放入堆中
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                /**
                 * 将对应元素添加进入队列
                 */
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode result = new ListNode(-1);
        ListNode head = result;
        while (!queue.isEmpty()) {
            /**
             * poll()方法，获取并删除队首元素
             */
            head.next = queue.poll();
            head = head.next;
        }
        head.next = null;
        return result.next;
    }
}

/**
 * 优化 利用堆做排序--优先级队列
 */
class Solution03 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // 创建小根堆，并定义好排序函数
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 保存结果
        ListNode result = new ListNode(-1);
        // 工作指针
        ListNode current = result;
        /**
         * 优化过程
         * 不是将所有的结点添加进入堆中
         * 而是只把k个链表的第一个节点放入堆中
         */
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                queue.add(head);
            }
        }
        /**
         * 之后不断从堆中取出结点，如果这个节点还有下一个节点，
         * 将下一个节点放入堆中
         */
        while (queue.size() > 0) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        current.next = null;
        return result.next;
    }
}


/**
 * 测试类
 */
public class Study0023 {
    public static void main(String[] args) {
        ListNode[] a = new ListNode[]{new ListNode(1), new ListNode(4), new ListNode(5)};
        a[0].next = a[1];
        a[1].next = a[2];
        a[2].next = null;
        ListNode[] b = new ListNode[]{new ListNode(1), new ListNode(3), new ListNode(4)};
        b[0].next = b[1];
        b[1].next = b[2];
        b[2].next = null;
        ListNode[] c = new ListNode[]{new ListNode(2), new ListNode(6)};
        c[0].next = c[1];
        c[1].next = null;
        ListNode[] list = {a[0], b[0], c[0]};
        ListNode result = new Solution03().mergeKLists(list);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }
}
