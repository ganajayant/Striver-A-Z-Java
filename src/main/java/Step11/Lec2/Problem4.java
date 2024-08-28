package Step11.Lec2;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Node implements Comparable<Node> {
    ListNode node;

    public Node(ListNode node) {
        this.node = node;
    }

    @Override
    public int compareTo(Node o) {
        return this.node.val - o.node.val;
    }
}

public class Problem4 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode temp = head;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(new Node(list));
            }
        }
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            temp.next = node.node;
            temp = temp.next;
            if (node.node.next != null) {
                pq.add(new Node(node.node.next));
            }
        }
        return head.next;
    }
}
