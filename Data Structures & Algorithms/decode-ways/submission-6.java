class Solution {
    int[] dp;
    int countWays(int i, String s) {
        if (i == 0)
            return 1;
        if (i < 0)
            return 0;

        if (dp[i] != 0)
            return dp[i];

        int res = 0;

        if (s.charAt(i - 1) != '0') {
            res += countWays(i - 1, s);
        }

        if (i >= 2) {
            int num = Integer.parseInt(s.substring(i - 2, i));
            if (num >= 10 && num <= 26) {
                res += countWays(i - 2, s);
            }
        }

        return dp[i] = res;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int prev = 1;
        int prev2 = 0;

        for (int i = 1; i <= n; i++) {
            int cur = 0;
            if (s.charAt(i - 1) != '0') {
                cur += prev;
            }

            if (i >= 2) {
                int num = Integer.parseInt(s.substring(i - 2, i));
                if (num >= 10 && num <= 26) {
                    cur += prev2;
                }
            }
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
