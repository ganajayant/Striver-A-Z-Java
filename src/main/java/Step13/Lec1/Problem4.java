package Step13.Lec1;

import java.util.LinkedList;
import java.util.List;

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

public class Problem4 {
    static LinkedList<Integer> l1 = new LinkedList<>();
    static LinkedList<Integer> l2 = new LinkedList<>();
    static LinkedList<Integer> l3 = new LinkedList<>();

    private static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            l1.add(root.data);
            inorder(root.right);
        }
    }

    private static void preorder(TreeNode root) {
        if (root != null) {
            l2.add(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    private static void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            l3.add(root.data);
        }
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        inorder(root);
        preorder(root);
        postorder(root);
        List<List<Integer>> result = new LinkedList<>();
        result.add(l1);
        result.add(l2);
        result.add(l3);
        return result;
    }
}
