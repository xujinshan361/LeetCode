package com.xujinshan.offer.offer09;

/**
 * @Author: xujinshan361@163.com
 * 剑指 Offer 09 -- 用两个队列实现栈
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail
 * 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 维护俩个栈操作
 * 第一个栈支持插入操作，第二个栈支持删除操作
 * 根据栈先进后出的特性，每次往第一个栈里插入元素后，第一个栈的底部元素是最后插入的
 * 元素，第一个栈的顶部元素是下一个待插入的元素，为了维护队列先进先出的特性，用第二个
 * 栈维护删除的元素，在执行删除操作的时候首先看下第二个栈是否为空。如果为空，将第一个
 * 栈里面的元素一个个弹出插入到第二个栈里面，这样第二个栈里元素的顺序就是待删除的元素
 * 的顺序，要执行删除操作时候直接弹出第二个栈的元素即可。
 */
class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        // 插入元素，直接插入第一个栈中
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                // 第一个栈不为空，将第一个栈的元素加入第二个栈
                stack2.push(stack1.pop());
            }
        }
        // 第二个栈为空，表示没有元素
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
public class Offer09 {
    public static void main(String[] args) {
        // 测试：插入1,2,3, 然后删除四次(最后一次为-1)
        CQueue cq = new CQueue();
        cq.appendTail(1);
        cq.appendTail(2);
        cq.appendTail(3);
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
    }
}
