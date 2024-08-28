package Step14.Lec2;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Problem11 {
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }

    private boolean findTarget(TreeNode root, TreeNode node, int k) {
        if (node == null) {
            return false;
        }
        return search(root, node, k - node.val) || findTarget(root, node.left, k) || findTarget(root, node.right, k);
    }

    private boolean search(TreeNode root, TreeNode node, int value) {
        if (root == null) {
            return false;
        }
        if (root.val == value && root != node) {
            return true;
        }
        if (root.val < value) {
            return search(root.right, node, value);
        }
        return search(root.left, node, value);
    }
}
