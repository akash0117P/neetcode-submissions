class Solution {
    int n;
    int m;
    int[][] visit;
    int fresh;
    int dist;
    Queue<Pair<Integer, Integer>> q;
    int[] rows = {-1, 0, 1, 0};
    int[] cols = {0, 1, 0, -1};

    void bfs(int[][] grid) {
        dist = 0;

        while (!q.isEmpty() && fresh > 0) {
            int k = q.size();

            for (int i = 0; i < k; i++) {
                Pair<Integer, Integer> pr = q.poll();
                int row = pr.getKey();
                int col = pr.getValue();

                for (int j = 0; j < 4; j++) {
                    int delRow = row + rows[j];
                    int delCol = col + cols[j];

                    if (delRow >= 0 && delRow < n && delCol >= 0 && delCol < m
                        && grid[delRow][delCol] == 1) {
                        fresh--;
                        grid[delRow][delCol] = 2;
                        q.offer(new Pair(delRow, delCol));
                    }
                }
            }
            dist++;
        }
    }
    public int orangesRotting(int[][] grid) {
        q = new LinkedList<>();
        n = grid.length;
        m = grid[0].length;

        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                } else {
                    if (grid[i][j] == 1) {
                        fresh++;
                    }
                }
            }
        }

        bfs(grid);
        return fresh == 0 ? dist : -1;
    }
}
