package Step13.Lec2;

import java.util.LinkedList;
import java.util.List;

public class Problem7 {
    static List<Integer> result;

    private static void addallleafes(TreeNode root) {
        if (root == null) {
            return;
        }
        addallleafes(root.left);
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        addallleafes(root.right);
    }

    private static void travel(TreeNode root, int flag) {
        if (root == null) {
            return;
        }
        if (flag == Integer.MAX_VALUE) {
            result.add(root.val);
            travel(root.left, 1);
            travel(root.right, 2);
            return;
        } else if (flag == 1) {
            result.add(root.val);
            if (root.left == null) {
                travel(root.right, 1);
                return;
            }
            travel(root.left, 1);
            travel(root.right, 3);
        } else if (flag == 2) {
            if (root.right == null) {
                travel(root.left, 2);
                result.add(root.val);
                return;
            }
            travel(root.left, 3);
            travel(root.right, 2);
            result.add(root.val);
        } else {
            addallleafes(root);
        }
    }

    public static List<Integer> traverseBoundary(TreeNode root) {
        result = new LinkedList<>();
        travel(root, Integer.MAX_VALUE);
        return result;
    }
}
