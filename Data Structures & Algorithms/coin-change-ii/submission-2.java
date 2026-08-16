class Solution {
    int[][] dp;
    int dfs(int i, int amount, int[] nums) {
        if (amount == 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int take = 0;
        if (nums[i] <= amount) {
            take = dfs(i, amount - nums[i], nums);
        }
        int notake = dfs(i - 1, amount, nums);

        return dp[i][amount] = take + notake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(n-1, amount, coins);
    }
}
