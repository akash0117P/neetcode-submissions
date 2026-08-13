class Solution {
    int[] dp;
    int climb(int k, int n) {
        if (k > n)
            return 0;
        if (k == n)
            return 1;
        if (dp[k] != 0)
            return dp[k];

        return dp[k] = climb(k + 1, n) + climb(k + 2, n);
    }
    public int climbStairs(int n) {
        dp = new int[n];

        return climb(0, n);
    }
}
