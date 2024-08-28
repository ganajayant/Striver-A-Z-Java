package Step13.Lec1;

import java.util.LinkedList;
import java.util.List;

public class Problem6 {
    static LinkedList<Integer> l1 = new LinkedList<>();

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

    private static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            l1.add(root.data);
            inorder(root.right);
        }
    }

    public static List<Integer> getTreeTraversal(TreeNode root) {
        inorder(root);
        return l1;
    }
}
