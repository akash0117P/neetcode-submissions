class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int take = 0;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    take = dp[i - 1][j - 1];
                }
                int notake = dp[i - 1][j];

                dp[i][j] = take + notake;
            }
        }

        return dp[n][m];
    }
}
