package Step15.Lec5;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Problem8 {
    class DisjointSet {
        int n;
        int[] parent;
        int[] rank;

        public DisjointSet(int n) {
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int FindUParent(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = FindUParent(parent[i]);
        }

        public void union(int i, int j) {
            int ParentI = FindUParent(i);
            int ParentJ = FindUParent(j);
            if (ParentJ == ParentI) {
                return;
            }
            if (rank[ParentI] < rank[ParentJ]) {
                parent[ParentI] = ParentJ;
            } else if (rank[ParentI] > rank[ParentJ]) {
                parent[ParentJ] = ParentI;
            } else {
                parent[ParentI] = ParentJ;
                rank[ParentI]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String str = accounts.get(i).get(j);
                if (!map.containsKey(str)) {
                    map.put(str, i);
                } else {
                    ds.union(map.get(str), i);
                }
            }
        }
        LinkedList<LinkedList<String>> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            result.add(new LinkedList<>());
        }
        for (String str : map.keySet()) {
            int val = map.get(str);
            int node = ds.FindUParent(val);
            result.get(node).add(str);
        }
        List<List<String>> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (result.get(i).size() == 0)
                continue;
            Collections.sort(result.get(i));
            List<String> temp = new LinkedList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : result.get(i)) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}
