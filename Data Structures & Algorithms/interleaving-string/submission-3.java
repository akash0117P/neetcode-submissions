class Solution {
    Boolean[][] dp;
    boolean dfs(int i, int j, String s1, String s2, String s3) {
        if (i + j == s3.length()) {
            return i == s1.length() && j == s2.length();
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean takeS1 = false;
        boolean takeS2 = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            takeS1 = dfs(i + 1, j, s1, s2, s3);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            takeS2 = dfs(i, j + 1, s1, s2, s3);
        }
        return dp[i][j] = takeS1 || takeS2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        dp = new Boolean[n + 1][m + 1];
        return dfs(0, 0, s1, s2, s3);
    }
}
