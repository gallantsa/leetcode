package 二叉树._257_二叉树的所有路径;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
// 返回所有从根节点到叶子结点的路径
class Solution {

    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        deal(root, "");
        return result;
    }

    private void deal(TreeNode node, String s) {
        if (node == null) return;
        // 到达叶子结点, 添加路径
        if (node.left == null && node.right == null) {
            result.add(new StringBuilder(s).append(node.val).toString());
            return;
        }
        String tmp = new StringBuilder(s).append(node.val).append("->").toString();
        deal(node.left, tmp);
        deal(node.right, tmp);
    }
}