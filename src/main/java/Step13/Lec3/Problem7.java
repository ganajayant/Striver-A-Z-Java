package Step13.Lec3;

public class Problem7 {
    public int countNodes(TreeNode root) {
        int ans = 0;
        if (root == null)
            return 0;
        if (root.right != null) {
            int r = countNodes(root.right);
            ans += r;
        }
        if (root.left != null) {
            int l = countNodes(root.left);
            ans += l;
        }
        return ans + 1;
    }
}
