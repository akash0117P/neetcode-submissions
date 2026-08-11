class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][n];
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[] {grid[0][0], 0, 0});
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int t = temp[0];
            int r = temp[1];
            int c = temp[2];

            if (r == n - 1 && c == m - 1)
                return t;
            for (int i = 0; i < 4; i++) {
                int delRow = r + rows[i];
                int delCol = c + cols[i];
                if (delRow < n && delRow >= 0 && delCol >= 0 && delCol < m
                    && !visit[delRow][delCol]) {
                    visit[delRow][delCol] = true;
                    int maxT = Math.max(t, grid[delRow][delCol]);
                    pq.offer(new int[] {maxT, delRow, delCol});
                }
            }
        }

        return n * n;
    }
}
