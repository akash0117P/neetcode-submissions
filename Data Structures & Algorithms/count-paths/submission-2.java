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
        return dfs(m - 1, n - 1, m, n);
    }
}
