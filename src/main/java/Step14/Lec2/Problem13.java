package Step14.Lec2;

public class Problem13 {
    private static boolean isBst(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return isBst(root.left, min, root.data - 1) && isBst(root.right, root.data + 1, max);
    }

    private static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    static int largestBst(Node root) {
        if (root == null) {
            return 0;
        }
        if (isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
        return Math.max(largestBst(root.left), largestBst(root.right));
    }
}
