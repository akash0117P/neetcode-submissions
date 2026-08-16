class Solution {
    int[][] dp;
    int dfs(int i, int buy, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }

        if (dp[i][buy] != 0) {
            return dp[i][buy];
        }

        if (buy == 1) {
            return dp[i][buy] = Math.max(-prices[i] + dfs(i + 1, 0, prices), dfs(i + 1, 1, prices));
        } else {
            return dp[i][buy] = Math.max(prices[i] + dfs(i + 2, 1, prices), dfs(i + 1, 0, prices));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        return dfs(0, 1, prices);
    }
}
