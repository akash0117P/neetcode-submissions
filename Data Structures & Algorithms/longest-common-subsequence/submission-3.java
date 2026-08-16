class Solution {
    int[][] dp;
    int dfs(int i, int j, String text1, String text2) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + dfs(i - 1, j - 1, text1, text2);
        }

        return dp[i][j] = Math.max(dfs(i - 1, j, text1, text2), dfs(i, j - 1, text1, text2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n][m];
        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        }

        for (int j = 1; j < m; j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n - 1][m - 1];
    }
}
