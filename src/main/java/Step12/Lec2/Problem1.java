package Step12.Lec2;

import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        return this.end - o.end;
    }
}

public class Problem1 {
    public static int maxMeetings(int start[], int end[], int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Node(start[i], end[i]));
        }
        int count = 1;
        Node prev = pq.poll();
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.start > prev.end) {
                count++;
                prev = curr;
            }
        }
        return count;
    }
}
