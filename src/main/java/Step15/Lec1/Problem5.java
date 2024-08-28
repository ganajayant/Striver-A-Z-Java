package Step15.Lec1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Problem5 {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited.contains(node)) {
                result.add(node);
                visited.add(node);
                for (int i : adj.get(node)) {
                    if (!visited.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }
        return result;
    }
}
