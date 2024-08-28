package Step13.Lec1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Problem2 {
    public static void createTree(Node root0, ArrayList<Integer> v) {
        Queue<Node> q = new LinkedList<>();
        int i = 1;
        q.add(root0);
        while (!q.isEmpty() && i < v.size()) {
            Node temp = q.poll();
            if (i < v.size()) {
                temp.left = new Node(v.get(i++));
                q.add(temp.left);
            }
            if (i < v.size()) {
                temp.right = new Node(v.get(i++));
                q.add(temp.right);
            }
        }
        return;
    }
}
