package Step13.Lec2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair {
    int y;
    Node root;

    public Pair(int y, Node root) {
        this.y = y;
        this.root = root;
    }
}

public class Problem9 {
    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer, Node> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            if (!map.containsKey(temp.y)) {
                map.put(temp.y, temp.root);
            }
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
