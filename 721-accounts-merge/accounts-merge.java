import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        List<List<String>> ans = new ArrayList<List<String>>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (hm.containsKey(accounts.get(i).get(j))) {
                    ds.union(i, hm.get(accounts.get(i).get(j)));
                } else {
                    hm.put(accounts.get(i).get(j), i);
                }
            }
        }

        ArrayList<String> res[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            int uTp = ds.find(e.getValue());
            res[uTp].add(e.getKey());
        }
        for (int i = 0; i < n; i++) {
            if (res[i].size() == 0) {
                continue;
            }
            List<String> temp = new ArrayList<String>();
            Collections.sort(res[i]);
            temp.add(accounts.get(i).get(0));
            for (String e : res[i]) {
                temp.add(e);
            }
            ans.add(temp);
        }

        return ans;

    }

    class DisjointSet {

        static int par[];
        static int rank[];

        // Initialization: Set each element as a parent of itself and rank as 0
        public DisjointSet(int n) {
            par = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                rank[i] = 0;
            }
        }

        public DisjointSet() {

        }

        // Find operation with path compression
        public int find(int x) {
            if (x == par[x])
                return x;
            return par[x] = find(par[x]); // Path compression: Update parent to root during find
        }

        // Union operation with rank-based optimization
        public void union(int a, int b) {
            int parA = find(a);
            int parB = find(b);

            if (rank[parA] == rank[parB]) {
                par[parB] = parA;
                rank[parA]++;
            } else if (rank[parA] < rank[parB]) {
                par[parA] = parB;
            } else {
                par[parB] = parA;
            }
        }

    }
}