package Step13.Lec2;

public class Problem5 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean left = isSameTree(p.left, q.left);
        if (!left) {
            return false;
        }
        return isSameTree(p.right, q.right);
    }
}
