package Step9.Lec4;

import java.util.HashMap;
import java.util.TreeMap;

class LFUCache {
    class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
            prev = null;
            next = null;
        }

        public Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
            prev = null;
            next = null;
        }
    }

    class DoublyLinkedList {
        Node head, tail;

        public DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public boolean isEmpty() {
            if (head.next == tail) {
                return true;
            }
            return false;
        }

        public void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        public void add(Node node) {
            Node prevNode = tail.prev;
            prevNode.next = node;
            node.prev = prevNode;
            node.next = tail;
            tail.prev = node;
        }
    }

    int capacity;
    TreeMap<Integer, DoublyLinkedList> frequency;
    HashMap<Integer, Node> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.frequency = new TreeMap<>();
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node result = map.get(key);
        int freq = result.frequency;
        DoublyLinkedList dll = frequency.get(freq);
        dll.remove(result);
        if (dll.isEmpty()) {
            frequency.remove(freq);
        }
        freq++;
        Node newNode = new Node(key, result.value, freq);
        frequency.putIfAbsent(freq, new DoublyLinkedList());
        frequency.get(freq).add(newNode);
        map.put(key, newNode);
        return result.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node result = map.get(key);
            int freq = result.frequency;
            DoublyLinkedList dll = frequency.get(freq);
            dll.remove(result);
            if (dll.isEmpty()) {
                frequency.remove(freq);
            }
            freq++;
            Node newNode = new Node(key, value, freq);
            frequency.putIfAbsent(freq, new DoublyLinkedList());
            frequency.get(freq).add(newNode);
            map.put(key, newNode);
        } else {
            if (map.size() == capacity) {
                int minFreq = frequency.firstKey();
                DoublyLinkedList dll = frequency.get(minFreq);
                Node node = dll.head.next;
                dll.remove(node);
                if (dll.isEmpty()) {
                    frequency.remove(minFreq);
                }
                map.remove(node.key);
            }
            Node newNode = new Node(key, value);
            frequency.putIfAbsent(1, new DoublyLinkedList());
            frequency.get(1).add(newNode);
            map.put(key, newNode);
        }
    }
}

public class Problem5 {

}
