class Solution {
    int n;
    int m;
    boolean[][] pac;
    boolean[][] atl;
    int[] rows = {-1, 0, 1, 0};
    int[] cols = {0, 1, 0, -1};
    void dfs(int row, int col, boolean[][] ocean, int[][] heights) {
        ocean[row][col] = true;
        for (int k = 0; k < 4; k++) {
            int r = row + rows[k];
            int c = col + cols[k];
            if (r >= 0 && r < n && c >= 0 && c < m && heights[row][col] <= heights[r][c]
                && !ocean[r][c]) {
                dfs(r, c, ocean, heights);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        n = heights.length;
        m = heights[0].length;

        pac = new boolean[n][m];
        atl = new boolean[n][m];

        for (int c = 0; c < m; c++) {
            dfs(0, c, pac, heights);
            dfs(n - 1, c, atl, heights);
        }
        for (int r = 0; r < n; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, m - 1, atl, heights);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return res;
    }
}
