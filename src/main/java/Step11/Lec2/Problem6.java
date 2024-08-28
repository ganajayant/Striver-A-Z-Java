package Step11.Lec2;

import java.util.LinkedList;
import java.util.PriorityQueue;

class Problem6Node implements Comparable<Problem6Node> {
    char val;
    int count;

    public Problem6Node(char val, int count) {
        this.val = val;
        this.count = count;
    }

    @Override
    public int compareTo(Problem6Node o) {
        return o.count - this.count;
    }
}

public class Problem6 {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Problem6Node> pq = new PriorityQueue<>();
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                pq.add(new Problem6Node((char) (i + 'A'), map[i]));
            }
        }
        int time = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            LinkedList<Problem6Node> temp = new LinkedList<>();
            while (k > 0 && !pq.isEmpty()) {
                Problem6Node cur = pq.poll();
                cur.count--;
                temp.add(cur);
                time++;
                k--;
            }
            for (Problem6Node node : temp) {
                if (node.count > 0) {
                    pq.add(node);
                }
            }
            if (pq.isEmpty()) {
                break;
            }
            time += k;
        }
        return time;
    }
}