class Solution {
    int[] rows = {-1, 0, 1, 0};
    int[] cols = {0, 1, 0, -1};
    int[][] dp;
    int dfs(int i, int j, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxi = 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        for (int r = 0; r < 4; r++) {
            int nr = i + rows[r];
            int nc = j + cols[r];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[i][j] < matrix[nr][nc]) {
                maxi = Math.max(maxi, 1 + dfs(nr, nc, matrix));
            }
        }
        return dp[i][j] = maxi;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(i, j, matrix));
            }
        }
        return ans;
    }
}
