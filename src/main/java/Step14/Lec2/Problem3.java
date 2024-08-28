package Step14.Lec2;

public class Problem3 {
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

    private void insert(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            insert(root.right, val);
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            insert(root.left, val);
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        insert(root, val);
        return root;
    }
}