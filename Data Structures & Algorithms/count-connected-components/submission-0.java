class Solution {
    List<List<Integer>> adj;
    int[] vis;
    int comp;

    void dfs(int node) {
        for (int adjNode : adj.get(node)) {
            if (vis[adjNode] != 1) {
                vis[adjNode] = 1;
                dfs(adjNode);
            }
        }
        return;
    }
    public int countComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        vis = new int[n];
        comp = 0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] != 1) {
                comp++;
                dfs(i);
            }
        }
        return comp;
    }
}
