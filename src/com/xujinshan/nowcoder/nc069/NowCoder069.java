package com.xujinshan.nowcoder.nc069;

/**
 * @Author: xujinshan361@163.com
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 * 示例1
 * 输入
 * <p>
 * {1,2,3,4,5},1
 * <p>
 * 返回值
 * <p>
 * {5}
 */

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        ListNode pre = pHead;
        ListNode cur = pHead;
        while(k>0){
            if(cur ==null){
                return null;
            }
            cur = cur.next;
            k--;
        }
        while(cur!=null){
            cur=cur.next;
            pre = pre.next;
        }
        return pre;
    }
}

public class NowCoder069 {
    public static void main(String[] args) {

    }
}
