package _21_构造二叉树;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 多组输⼊，每组输⼊包含两个字符串，输出字符串
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            String pre = s[0];
            String in = s[1];

            // 构造二叉树
            TreeNode root = afterHelper(pre.toCharArray(), in.toCharArray());

            // 打印二叉树
            printTree(root);
            System.out.println();

        }
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;

        printTree(root.left);
        printTree(root.right);
        System.out.print(root.val);
    }

    static Map<Character, Integer> valToIndex = new HashMap<>();

    private static TreeNode afterHelper(char[] preorder, char[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
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
}
