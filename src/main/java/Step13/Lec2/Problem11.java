package Step13.Lec2;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Problem11 {
    TreeMap<Integer, Integer> map;

    private void travel(TreeNode root, int val) {
        if (root != null) {
            if (!map.containsKey(val)) {
                map.put(val, root.val);
            }
            travel(root.right, val + 1);
            travel(root.left, val + 1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        map = new TreeMap<>();
        List<Integer> result = new LinkedList<>();
        travel(root, 0);
        for (Integer integer : map.keySet()) {
            result.add(map.get(integer));
        }
        return result;
    }
}
