class Solution {
    int n;
    int m;
    int[][] vis;
    int cnt = 0;

    void bfs(int i, int j, char[][] grid) {
        vis[i][j] = 1;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(i, j));

        while (!q.isEmpty()) {
            Pair<Integer, Integer> pr = q.poll();
            int newRow = pr.getKey();
            int newCol = pr.getValue();

            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};

            for (int k = 0; k < 4; k++) {
                int row = newRow + dr[k];
                int col = newCol + dc[k];
                if (row < n && row >= 0 && col < m && col >= 0 && grid[row][col] == '1'
                    && vis[row][col] != 1) {
                    vis[row][col] = 1;
                    q.offer(new Pair<>(row, col));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    cnt++;
                    bfs(i, j, grid);
                }
            }
        }
        return cnt;
    }
}
