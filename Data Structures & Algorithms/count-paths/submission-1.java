class Solution {
    int[][] dp;
    int dfs(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (i >= n || j >= m) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int bottom = dfs(i + 1, j, n, m);
        int right = dfs(i, j + 1, n, m);

        return dp[i][j]=bottom + right;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return dfs(0, 0, m, n);
    }
}
