package com.xujinshan.nowcoder.nc050;

/**
 * @Author: xujinshan361@163.com
 * NowCoder050--链表中的节点每k个一组翻转
 * 题目描述
 * 将给出的链表中的节点每 k\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度  O(1)\ O(1) O(1)
 * 例如：
 * 给定的链表是1→2→3→4→5
 * 对于  k=2, 你应该返回 2→1→4→3→5
 * 对于  k=3 你应该返回 3→2→1→4→5
 *
 * 示例1
 * 输入
 *
 * {1,2,3,4,5},2
 *
 * 返回值
 *
 * {2,1,4,3,5}
 */
import java.util.*;


class ListNode {
   int val;
   ListNode next = null;
  }


class Solution {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        // 保存结果
        ListNode result = new ListNode();
        result.next = head;
        // 待翻转链表的前驱和末尾
        ListNode pre = result;
        ListNode end = result;

        while(end.next!=null){
            // 移动ned 指针，找到需要翻转的部分
            for(int i =0;i<k&&end!=null;i++){
                end = end.next;
            }
            // 如果待翻转的部分不足k个，直接返回
            if(end==null){
                break;
            }
            // 保存需要翻转的开始节点
            ListNode start = pre.next;
            // 保存未翻转的开始节点
            ListNode next = end.next;
            end.next =null;
            // 执行翻转操作
            pre.next = reverse(start);
            // 初始化指针，执行下一次翻转操作
            start.next = next;
            pre =start;
            end = pre;
        }
        return result.next;
    }
    private ListNode reverse(ListNode head) {
        // 保存翻转后的结果
        ListNode pre = null;
        // 工作指针
        ListNode current = head;
        while (current != null) {
            // 保存待翻转的下一个节点
            ListNode next = current.next;
            // 将一个节点取下，插入到pre之后，类似于头插法建立单链表
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
public class NowCoder050 {
    public static void main(String[] args) {

        
    }
}
