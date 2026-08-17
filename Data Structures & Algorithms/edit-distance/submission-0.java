class Solution {
    int[][] dp;
    int dfs(int i, int j, String word1, String word2) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = dfs(i - 1, j - 1, word1, word2);
        } else {
            int maxi =
                Math.min(1 + dfs(i - 1, j - 1, word1, word2), 1 + dfs(i - 1, j, word1, word2));

            maxi = Math.min(maxi, 1 + dfs(i, j - 1, word1, word2));
            return dp[i][j] = maxi;
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(n - 1, m - 1, word1, word2);
    }
}
