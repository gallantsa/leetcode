package 二叉树._173_二叉搜索树迭代器;

import 二叉树.TreeNode;

import java.util.Stack;

public class Main {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// 将迭代版的中序遍历代码做等价拆分
class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        dfsLeft(root);
    }

    private void dfsLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode root = stack.pop();
        int ans = root.val;
        root = root.right;
        dfsLeft(root);
        return ans;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */