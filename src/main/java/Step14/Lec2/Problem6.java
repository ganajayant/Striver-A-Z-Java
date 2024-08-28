package Step14.Lec2;

public class Problem6 {
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

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long lowerBound, long higherBound) {
        if (node == null) {
            return true;
        }
        return node.val > lowerBound && node.val < higherBound && isValid(node.left, lowerBound, node.val)
                && isValid(node.right, node.val, higherBound);
    }
}
