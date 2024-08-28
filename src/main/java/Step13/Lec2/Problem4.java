package Step13.Lec2;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Problem4 {
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;

    private void inorder(TreeNode root, int index, int level) {
        if (root == null) {
            return;
        }
        map.computeIfAbsent(index, k -> new TreeMap<>()).computeIfAbsent(level, k -> new PriorityQueue<>())
                .add(root.val);
        inorder(root.left, index - 1, level + 1);
        inorder(root.right, index + 1, level + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return null;
        map = new TreeMap<>();
        inorder(root, 0, 0);
        List<List<Integer>> res = new LinkedList<>();
        for (int key : map.keySet()) {
            List<Integer> list = new LinkedList<>();
            TreeMap<Integer, PriorityQueue<Integer>> tm = map.get(key);
            for (int k : tm.keySet()) {
                PriorityQueue<Integer> pq = tm.get(k);
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
}
