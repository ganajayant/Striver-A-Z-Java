package Step12.Lec2;

import java.util.HashMap;

public class Problem8 {
    static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private static Node head;
    private static Node tail;

    public static int pageFaults(int N, int C, int[] pages) {
        HashMap<Integer, Node> map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        int count = 0;
        for (int i : pages) {
            if (map.containsKey(i)) {
                Node node = map.get(i);
                remove(node);
                insertAtHead(node);
            } else {
                count++;
                if (map.size() == C) {
                    Node lru = tail.prev;
                    remove(lru);
                    map.remove(lru.value);
                }
                Node newNode = new Node(i);
                insertAtHead(newNode);
                map.put(i, newNode);
            }
        }
        return count;
    }

    private static void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static void insertAtHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
