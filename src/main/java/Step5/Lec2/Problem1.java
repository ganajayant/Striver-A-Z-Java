package Step5.Lec2;

import java.util.PriorityQueue;

public class Problem1 {
    public String frequencySort(String s) {
        int[] table = new int[256];
        for (char c : s.toCharArray()) {
            table[c]++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> table[b] - table[a]);
        for (int i = 0; i < 256; i++) {
            if (table[i] > 0) {
                pq.add((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < table[c]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
