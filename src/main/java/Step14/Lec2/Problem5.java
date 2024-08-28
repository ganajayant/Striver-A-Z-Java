package Step14.Lec2;

public class Problem5 {
    int count = 0;
    int val = 0;

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

    private void inorder(TreeNode root, int k) {
        if (root != null) {
            inorder(root.left, k);
            count++;
            if (count == k) {
                val = root.val;
            }
            inorder(root.right, k);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return val;
    }
}
