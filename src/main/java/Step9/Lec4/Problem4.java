package Step9.Lec4;

import java.util.TreeMap;

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Node head;
    Node tail;
    int capacity;
    TreeMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new TreeMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void add(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        Node node = map.get(key);
        remove(node);
        add(node);
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
        } else {
            if (map.size() == this.capacity) {
                Node node = head.next;
                remove(node);
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
    }
}

public class Problem4 {

}