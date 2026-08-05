class Solution {
    List<List<Integer>> adj;
    Queue<Pair<Integer, Integer>> q;
    int[] vis;
    boolean ans;

    boolean bfs(int parent, int node) {
        q.offer(new Pair<>(node, parent));

        while (!q.isEmpty()) {
            Pair<Integer, Integer> pr = q.poll();
            int curNode = pr.getKey();
            int curNodeParent = pr.getValue();

            for (int adjNode : adj.get(curNode)) {
                if (vis[adjNode] != 1) {
                    vis[adjNode] = 1;
                    q.offer(new Pair<>(adjNode, curNode));
                } else {
                    if (adjNode != curNodeParent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        adj = new ArrayList<>();
        q = new LinkedList<>();
        vis = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        vis[0] = 1;

        if (bfs(-1, 0)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                return false;
            }
        }

        return !ans;
    }
}
