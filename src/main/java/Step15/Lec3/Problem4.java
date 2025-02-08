package Step15.Lec3;

import java.util.HashMap;
import java.util.LinkedList;

public class Problem4 {
    private boolean dfs(int node, HashMap<Integer, LinkedList<Integer>> map, int[] visited) {
        visited[node] = 1;
        for (int j : map.get(node)) {
            if (visited[j] == 1) {
                return false;
            }
            if (visited[j] == 0 && !dfs(j, map, visited)) {
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new LinkedList<>());
        }
        for (int[] is : prerequisites) {
            map.get(is[0]).add(is[1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(i, map, visited)) {
                return false;
            }
        }
        return true;
    }
}
