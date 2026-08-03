class Solution {
    int n;
    int m;
    int[][] visit;
    Queue<Pair<Integer, Integer>> q;
    int[] rows = {-1, 0, 1, 0};
    int[] cols = {0, 1, 0, -1};

    void bfs(int[][] grid) {
        int dist = 0;

        while (!q.isEmpty()) {
            int k = q.size();

            for (int i = 0; i < k; i++) {
                Pair<Integer, Integer> pr = q.poll();
                int row = pr.getKey();
                int col = pr.getValue();
                grid[row][col] = dist;
                for (int j = 0; j < 4; j++) {
                    int delRow = row + rows[j];
                    int delCol = col + cols[j];

                    if (delRow >= 0 && delRow < n && delCol >= 0 && delCol < m
                        && grid[delRow][delCol] == 2147483647 && visit[delRow][delCol] != 1) {
                        visit[delRow][delCol] = 1;
                        q.offer(new Pair(delRow, delCol));
                    }
                }
            }
            dist++;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        q = new LinkedList<>();
        n = grid.length;
        m = grid[0].length;

        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    visit[i][j] = 1;
                    q.offer(new Pair(i, j));
                }
            }
        }

        bfs(grid);
        return;
    }
}
