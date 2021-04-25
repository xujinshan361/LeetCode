package com.xujinshan.leetcode.code0094;

/**
 * 0094-二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 示例 1：
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 *
 * 示例 5：
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *提示：
 *
 *     树中节点数目在范围 [0, 100] 内
 *     -100 <= Node.val <= 100
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node.
 *
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 递归实现
 */
class Solution01{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }
    // 中序递归实现
    public void inorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right,result);
    }
}

/**
 * 显示栈实现
 */

class Solution02{
    public List<Integer> inorderTraversal(TreeNode root){
        // 保存结果集
        List<Integer> result = new ArrayList<>();
        // 初始化一个栈
        Deque<TreeNode> stack =new ArrayDeque<>();
        while(root!=null||!stack.isEmpty()){
            while (root !=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
/**
 * 测试类
 */
public class Study0094 {
    public static void main(String[] args) {
        // 构造二叉树，示例第一种情况
        // 描述，1为根结点，左孩子为空，右孩子为2，结点2的左孩子为3，右孩子为空，结点3的左右孩子都为空
        TreeNode root = new TreeNode(1, null,new TreeNode(2,new TreeNode(3,null,null),null));
        // 保存结果
        List<Integer> result = new ArrayList<>();
        result = new Solution02().inorderTraversal(root);
        for(Integer data:result){
            System.out.print(data.toString()+"\t");
        }
    }
}
