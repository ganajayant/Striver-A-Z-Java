package Step13.Lec2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Problem10 {
    class Pair {
        int y;
        Node root;

        public Pair(int y, Node root) {
            this.y = y;
            this.root = root;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer, Node> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            map.put(temp.y, temp.root);
            if (temp.root.left != null) {
                q.add(new Pair(temp.y - 1, temp.root.left));
            }
            if (temp.root.right != null) {
                q.add(new Pair(temp.y + 1, temp.root.right));
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Node node : map.values()) {
            result.add(node.data);
        }
        return result;
    }
}
