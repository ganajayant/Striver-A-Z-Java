package Step13.Lec1;

import java.util.LinkedList;
import java.util.List;

public class Problem7 {
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

    private static void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            l1.add(root.data);
        }
    }

    public static List<Integer> getTreeTraversal(TreeNode root) {
        postorder(root);
        return l1;
    }
}
