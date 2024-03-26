package _23_二叉树的高度;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 多组测试数据，⾸先给出正整数N，接着输⼊两⾏字符串，字符串⻓度为N
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            sc.nextLine();
            char[] preOrder = sc.nextLine().toCharArray();
            char[] inOrder = sc.nextLine().toCharArray();
            TreeNode root = buildTree(preOrder, inOrder);
            int height = getHeight(root);
            System.out.println(height);
        }
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rootHeight = getHeight(root.right);
        return Math.max(leftHeight, rootHeight) + 1;
    }

    static Map<Character, Integer> valToIndex = new HashMap<>();
    private static TreeNode buildTree(char[] preOrder, char[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            valToIndex.put(inOrder[i], i);
        }
        return build(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    private static TreeNode build(char[] preorder, int preStart, int preEnd, char[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) return null;

        char rootVal = preorder[preStart];
        int index = valToIndex.get(rootVal);
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }
}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }

    public TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}