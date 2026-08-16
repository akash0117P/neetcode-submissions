class Solution {
    int[][] dp;
    int dfs(int s1, int s2, String text1, String text2) {
        if (s1 < 0 || s2 < 0) {
            return 0;
        }
        if(dp[s1][s2] != 0){
            return dp[s1][s2];
        }

        if (text1.charAt(s1) == text2.charAt(s2)) {
            return dp[s1][s2] = 1 + dfs(s1 - 1, s2 - 1, text1, text2);
        }

        return dp[s1][s2]=Math.max(dfs(s1 - 1, s2, text1, text2), dfs(s1, s2 - 1, text1, text2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n][m];
        
        return dfs(n - 1, m - 1, text1, text2);
    }
}
