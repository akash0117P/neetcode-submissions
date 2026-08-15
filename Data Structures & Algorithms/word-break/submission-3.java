class Solution {
    boolean[] dp;
    boolean dfs(int i, String s, List<String> wordDict) {
        if (i == s.length()) {
            return true;
        }
        if (dp[i] != false) {
            return dp[i];
        }

        for (String w : wordDict) {
            if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                if (dfs(i + w.length(), s, wordDict)) {
                    dp[i] = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
