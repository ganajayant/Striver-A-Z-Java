package Step13.Lec2;

public class Problem3 {
    int diameter;

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        diameter = Math.max(diameter, leftheight + rightheight);
        return 1 + Math.max(leftheight, rightheight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }
}
