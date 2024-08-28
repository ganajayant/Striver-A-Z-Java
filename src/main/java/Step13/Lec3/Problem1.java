package Step13.Lec3;

import java.util.ArrayList;

public class Problem1 {
    static ArrayList<ArrayList<Integer>> result;

    private static void f(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        f(root.left, path);
        f(root.right, path);
        path.remove(path.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        result = new ArrayList<>();
        f(root, new ArrayList<>());
        return result;
    }
}
