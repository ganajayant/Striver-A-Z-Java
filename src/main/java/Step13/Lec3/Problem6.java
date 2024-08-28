package Step13.Lec3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Problem6 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static Node MapParents(Node root, int target, HashMap<Node, Node> map) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node result = new Node(0);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.data == target) {
                result = temp;
            }
            if (temp.left != null) {
                map.put(temp.left, temp);
                queue.add(temp.left);
            }
            if (temp.right != null) {
                map.put(temp.right, temp);
                queue.add(temp.right);
            }
        }
        return result;
    }

    public static int minTime(Node root, int target) {
        HashMap<Node, Node> map = new HashMap<>();
        Node tar = MapParents(root, target, map);
        Queue<Node> queue = new LinkedList<>();
        queue.add(tar);
        HashSet<Node> visited = new HashSet<>();
        visited.add(tar);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (temp.left != null && !visited.contains(temp.left)) {
                    queue.add(temp.left);
                    visited.add(temp.left);
                    flag = true;
                }
                if (temp.right != null && !visited.contains(temp.right)) {
                    queue.add(temp.right);
                    visited.add(temp.right);
                    flag = true;
                }
                if (map.containsKey(temp) && !visited.contains(map.get(temp))) {
                    queue.add(map.get(temp));
                    visited.add(map.get(temp));
                    flag = true;
                }
            }
            if (flag) {
                result++;
            }
        }
        return result;
    }
}
