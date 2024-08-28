package Step13.Lec3;

public class Problem12 {
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if (left != null) {
            root.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
        root.left = null;
        return root;
    }

    public void flatten(TreeNode root) {
        root = dfs(root);
    }
}
