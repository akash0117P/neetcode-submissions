class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(
                new int[]{flight[1], flight[2]}
            );
        }

        // vis[node][number of flights taken]
        int[][] vis = new int[n][k + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }

        // {cost, flightsTaken, node}
        PriorityQueue<int[]> q =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        q.offer(new int[]{0, 0, src});
        vis[src][0] = 0;

        while (!q.isEmpty()) {

            int[] temp = q.poll();

            int dist = temp[0];
            int flightsTaken = temp[1];
            int node = temp[2];

            if (node == dst) {
                return dist;
            }

            if (flightsTaken == k + 1) {
                continue;
            }

            for (int[] adjNode : adj.get(node)) {

                int nextNode = adjNode[0];
                int price = adjNode[1];

                int newDist = dist + price;
                int newFlights = flightsTaken + 1;

                if (newDist < vis[nextNode][newFlights]) {

                    vis[nextNode][newFlights] = newDist;

                    q.offer(new int[]{
                        newDist,
                        newFlights,
                        nextNode
                    });
                }
            }
        }

        return -1;
    }
}