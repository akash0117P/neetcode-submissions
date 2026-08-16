class Solution {
    int[][] dp;
    int dfs(int i, int j, int m, int n) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int top = dfs(i - 1, j, m, n);
        int left = dfs(i, j - 1, m, n);

        return dp[i][j] = top + left;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int top = dp[i - 1][j];
                int left = dp[i][j - 1];
                dp[i][j] = top + left;
            }
        }

        return dp[m - 1][n - 1];
    }
}
