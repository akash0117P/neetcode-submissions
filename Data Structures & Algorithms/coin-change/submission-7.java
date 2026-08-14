class Solution {
    int[][] dp;
    int countWays(int i, int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        if (i < 0 || amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][amount] != -1)
            return dp[i][amount];

        int take = countWays(i, amount - coins[i], coins);
        if (take != Integer.MAX_VALUE) {
            take++;
        }
        int notake = countWays(i - 1, amount, coins);

        return dp[i][amount] = Math.min(take, notake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        if (amount == 0) {
            return 0;
        }
        int ans = countWays(n - 1, amount, coins);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
