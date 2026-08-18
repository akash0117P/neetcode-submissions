class Solution {
    Boolean dp[][];
    boolean dfs(int i, int j, String s, String p) {
        if (i < 0 && j < 0) {
            return true;
        }

        if (i >= 0 && j < 0) {
            return false;
        }

        if (i < 0) {
            for (int k = 1; k <= j; k += 2) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return j % 2 == 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            return dp[i][j] = dfs(i - 1, j - 1, s, p);
        }

        if (p.charAt(j) == '*') {
            boolean zero = dfs(i, j - 2, s, p);

            boolean more =
                (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dfs(i - 1, j, s, p);

            return dp[i][j] = zero || more;
        }

        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        dp = new Boolean[n][m];
        return dfs(n - 1, m - 1, s, p);
    }
}