package Step13.Lec3;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class Problem4 {
    private static boolean check(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int val1 = root.left == null ? 0 : root.left.data;
        int val2 = root.right == null ? 0 : root.right.data;
        if (root.data != val1 + val2) {
            return false;
        }
        return check(root.left) && check(root.right);

    }

    public static int isSumProperty(Node root) {
        return check(root) ? 1 : 0;
    }
}
