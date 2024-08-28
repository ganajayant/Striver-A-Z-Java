package Step6.Lec5;

import java.util.HashMap;

public class Problem4 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node iterator = head;
        HashMap<Node, Node> hm = new HashMap<>();
        while (iterator != null) {
            hm.put(iterator, new Node(iterator.val));
            iterator = iterator.next;
        }
        iterator = head;
        while (iterator != null) {
            hm.get(iterator).next = hm.get(iterator.next);
            hm.get(iterator).random = hm.get(iterator.random);
            iterator = iterator.next;
        }
        return hm.get(head);
    }
}
