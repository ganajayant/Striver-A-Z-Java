package Step13.Lec2;

public class Problem12 {
    private boolean check(TreeNode root1, TreeNode root2) {
        if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) {
            return false;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        return root1.val == root2.val && check(root1.left, root2.right) && check(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
}
