class Solution {
    int[][] dp;
    int countWays(int i, int amount, int[] coins) {
        if (i == 0) {
            if (amount % coins[i] == 0) {
                return amount / coins[i];
            } else {
                return 1_000_000_000;
            }
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int take = 1_000_000_000;
        if (amount >= coins[i]) {
            take = 1 + countWays(i, amount - coins[i], coins);
        }
        int notake = countWays(i - 1, amount, coins);

        return dp[i][amount] = Math.min(take, notake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount + 1];

        if (amount == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = 1_000_000_000;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int take = 1_000_000_000;
                if (t >= coins[i]) {
                    take = 1 + dp[i][t - coins[i]];
                }
                int notake = dp[i - 1][t];
                dp[i][t] = Math.min(take, notake);
            }
        }

        int ans = dp[n - 1][amount];
        return ans == 1_000_000_000 ? -1 : ans;
    }
}
