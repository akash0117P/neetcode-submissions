class Solution {
    int[][] dp;
    int countWays(int i, int sum, int amount, int[] coins) {
        if (sum == amount) {
            return 0;
        }
        if (i < 0 || sum > amount) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][sum] != -1)
            return dp[i][sum];

        int take = countWays(i, sum + coins[i], amount, coins);
        if (take != Integer.MAX_VALUE) {
            take++;
        }
        int notake = countWays(i - 1, sum, amount, coins);

        return dp[i][sum] = Math.min(take, notake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        dp = new int[n][amount];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        if (amount == 0) {
            return 0;
        }
        int ans = countWays(n - 1, 0, amount, coins);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
