class Solution {
    List<List<int[]>> adj;
    int[] dist;
    int ans;
    public int networkDelayTime(int[][] times, int n, int k) {
        adj = new ArrayList<>();
        dist = new int[n + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        dist[0] = 0;

        for (int[] edges : times) {
            int i = edges[0];
            adj.get(i).add(new int[] {edges[1], edges[2]});
        }

        pq.offer(new int[] {0, k});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int d = top[0];
            int node = top[1];

             if (d > dist[node]) {
                continue;
            }


            for (int[] adjNode : adj.get(node)) {
                int curNode = adjNode[0];
                int curDist = adjNode[1];

                curDist = curDist + d;

                if (curDist < dist[curNode]) {
                    pq.offer(new int[] {curDist, curNode});
                    dist[curNode] = curDist;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }
}
