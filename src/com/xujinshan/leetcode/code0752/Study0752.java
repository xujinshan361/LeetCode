package com.xujinshan.leetcode.code0752;

/**
 * 0752-打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3',
 * '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'
 * ，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，
 * 这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解
 * 锁，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" ->
 * "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"],
 * target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * <p>
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * BFS
 */
class Solution01 {
    /**
     * 解锁函数
     *
     * @param deadends 死亡数组
     * @param target   目标值
     * @return 需要旋转的次数
     */
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码 -- 使用Set 是为了避免添加重复值
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        // 初始化队列
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        // 保存需要的次数
        int step = 0;
        /*
         *从锁的初始值开始
         * offer() 如果在可以不违反容量限制的情况下立即将指定的元素插入此队列，
         * 当使用容量受限的队列时，此方法通常比 add() 更可取，add()可能会通过引发
         * 异常而无法插入元素。
         */
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            // 获取队列的长度
            int sz = q.size();
            // 将当前队列中的所有节点向周围扩散
            for (int i = 0; i < sz; i++) {
                // 获取对头元素，并出队列
                String cur = q.poll();
                // 判断是否到达终点
                if (deads.contains(cur)) {
                    // 当前值在死亡数组中，则直接跳过
                    continue;
                }
                if (cur.equals(target)) {
                    // 当前值为目标值，则直接返回 step
                    return step;
                }
                // 将一个节点的未遍历相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    // 向上旋转一次
                    String up = plusOne(cur, j);
                    // 判断，如果向上旋转一次，不在已经访问过的集合中，则将其加入队列，并加入访问过集合
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    // 向下旋转一次
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 这里增加步数
            step++;
        }
        // 如果穷举完都没有找到目标代码，则找不到，返回-1
        return -1;
    }

    /**
     * 将cur[j]向上拨动一次
     *
     * @param cur 当前字符串
     * @param j   需要向上拨动一次的位置
     * @return 旋转后的字符串
     */
    private String plusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    /**
     * 将cur[j]向下拨动一次
     *
     * @param cur 当前字符串
     * @param j   需要向下拨动一次的位置
     * @return 旋转后的字符串
     */
    private String minusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

}

/**
 * 双向BFS
 * 局限--必须知道终点在哪，例如二叉树的最小高度问题则不能使用
 */
class Solution02{
    /**
     * 解锁函数
     *
     * @param deadends 死亡数组
     * @param target   目标值
     * @return 需要旋转的次数
     */
    int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        // 用集合不用队列，可以快速判断元素是否存在
        // q1从头开始
        Set<String> q1 = new HashSet<>();
        // q2 从目标开始
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            // 将 q1 中的所有节点向周围扩散
            for (String cur : q1) {
                // 判断是否到达终点
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;
                visited.add(cur);

                // 将一个节点的未遍历相邻节点加入集合
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            // 在这里增加步数
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
    /**
     * 将cur[j]向上拨动一次
     *
     * @param cur 当前字符串
     * @param j   需要向上拨动一次的位置
     * @return 旋转后的字符串
     */
    private String plusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    /**
     * 将cur[j]向下拨动一次
     *
     * @param cur 当前字符串
     * @param j   需要向下拨动一次的位置
     * @return 旋转后的字符串
     */
    private String minusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
public class Study0752 {
    public static void main(String[] args) {
        System.out.println(new Solution01().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, new String("0202")));
        System.out.println(new Solution02().openLock(new String[]{"0000"}, "8888"));
    }
}
