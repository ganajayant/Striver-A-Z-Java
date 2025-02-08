package Step15.Lec3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Problem5 {
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

    private void dfs(int node, HashMap<Integer, LinkedList<Integer>> map, boolean[] visited, Stack<Integer> stacky) {
        visited[node] = true;
        for (int j : map.get(node)) {
            if (!visited[j]) {
                dfs(j, map, visited, stacky);
            }
        }
        stacky.push(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new LinkedList<>());
        }
        for (int[] is : prerequisites) {
            map.get(is[0]).add(is[1]);
        }
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stacky = new Stack<>();
        if (!canFinish(numCourses, prerequisites)) {
            return new int[0];
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i, map, visited, stacky);
            }
        }
        int size = stacky.size();
        int[] result = new int[size];
        int i = size - 1;
        while (!stacky.isEmpty()) {
            result[i--] = stacky.pop();
        }
        return result;
    }
}
