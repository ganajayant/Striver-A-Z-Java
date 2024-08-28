package Step13.Lec1;

import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static LinkedList<Integer> l1 = new LinkedList<>();

    private static void preorder(TreeNode root) {
        if (root != null) {
            l1.add(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static List<Integer> getTreeTraversal(TreeNode root) {
        preorder(root);
        return l1;
    }
}
