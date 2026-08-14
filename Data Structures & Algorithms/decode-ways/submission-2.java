class Solution {
    int[] dp;
    int countWays(int i, String s) {
        if (i == s.length())
            return 1;
        if (i > s.length())
            return 0;
        if (s.charAt(i) == '0')
            return 0;

        if (dp[i] != 0)
            return dp[i];
        int res = countWays(i + 1, s);

        if (i < s.length() - 1) {
            if ((s.charAt(i) == '1') || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                res += countWays(i + 2, s);
            }
        }

        return dp[i] = res;
    }
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        return countWays(0, s);
    }
}
