package Step16.Lec5;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Node {
    int i;
    int j;
    String str;

    public Node(int i, int j, String str) {
        this.i = i;
        this.j = j;
        this.str = str;
    }
}

public class Problem2 {
    public List<String> all_longest_common_subsequences(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] bottomup = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    bottomup[i][j] = 1 + bottomup[i - 1][j - 1];
                } else {
                    bottomup[i][j] = Math.max(bottomup[i - 1][j], bottomup[i][j - 1]);
                }
            }
        }

        Set<String> resultSet = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(m, n, ""));

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int i = temp.i;
            int j = temp.j;
            String str = temp.str;

            if (i == 0 || j == 0) {
                resultSet.add(new StringBuilder(str).reverse().toString());
                continue;
            }

            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                q.add(new Node(i - 1, j - 1, str + s.charAt(i - 1)));
            } else {
                if (bottomup[i - 1][j] >= bottomup[i][j - 1]) {
                    q.add(new Node(i - 1, j, str));
                }
                if (bottomup[i][j - 1] >= bottomup[i - 1][j]) {
                    q.add(new Node(i, j - 1, str));
                }
            }
        }
        List<String> resultList = new LinkedList<>(resultSet);
        Collections.sort(resultList);
        return resultList;
    }
}
