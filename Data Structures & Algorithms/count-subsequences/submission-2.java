class Solution {
    int[][] dp;
    int dfs(int i, int j, String s, String t) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = dfs(i - 1, j - 1, s, t);
        }
        int notake = dfs(i - 1, j, s, t);

        return dp[i][j] = take + notake;
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(n - 1, m - 1, s, t);
    }
}
