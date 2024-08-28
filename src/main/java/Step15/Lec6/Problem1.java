package Step15.Lec6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem1 {
    int[] dfs_number, low;
    int time = 1;
    List<List<Integer>> ans = new ArrayList<>();
    HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        dfs_number = new int[n];
        low = new int[n];
        for (int i = 0; i < n; i++)
            edgeMap.put(i, new ArrayList<Integer>());
        for (List<Integer> conn : connections) {
            edgeMap.get(conn.get(0)).add(conn.get(1));
            edgeMap.get(conn.get(1)).add(conn.get(0));
        }
        dfs(0, -1);
        return ans;
    }

    public void dfs(int curr, int prev) {
        dfs_number[curr] = low[curr] = time++;
        for (int next : edgeMap.get(curr)) {
            if (dfs_number[next] == 0) {
                dfs(next, curr);
                low[curr] = Math.min(low[curr], low[next]);
            } else if (next != prev) {
                low[curr] = Math.min(low[curr], dfs_number[next]);
            }
            if (low[next] > dfs_number[curr]) {
                ans.add(Arrays.asList(curr, next));
            }
        }
    }
}
