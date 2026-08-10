class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();
        int n = points.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int[] {dist, j});
                adj.get(j).add(new int[] {dist, i});
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] vis = new boolean[n];

        int ans = 0;

        q.offer(new int[] {0, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int dist = temp[0];
            int node = temp[1];
            if (vis[node]) {
                continue;
            }
            vis[node] = true;

            ans += dist;

            for (int[] adjNode : adj.get(node)) {
                int curDist = adjNode[0];
                int curNode = adjNode[1];

                if (vis[curNode] == false) {
                    q.offer(new int[] {curDist, curNode});
                }
            }
        }
        return ans;
    }
}
