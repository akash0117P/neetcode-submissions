class Solution {
    int[][] dp;
    int dfs(int i, int prev, int[] nums) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }
        int notake = dfs(i + 1, prev, nums);

        int take = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            take = 1 + dfs(i + 1, i, nums);
        }
        return dp[i][prev + 1] = Math.max(take, notake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int notake = dp[i + 1][prev + 1];

                int take = 0;
                if (prev == -1 || nums[prev] < nums[i]) {
                    take = 1 + dp[i + 1][i + 1];
                }
                dp[i][prev + 1] = Math.max(take, notake);
            }
        }
        return dp[0][0];
    }
}
