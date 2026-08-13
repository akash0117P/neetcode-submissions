class Solution {
    int[] dp;

    int rob(int k, int[] nums) {
        if (k < 0) {
            return 0;
        }
        if (dp[k] != 0)
            return dp[k];

        return dp[k] = Math.max(nums[k] + rob(k - 2, nums), rob(k - 1, nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i - 2 >= 0)
                take += dp[i - 2];

            int nonTake = dp[i - 1];

            dp[i] = Math.max(take, nonTake);
        }

        return dp[n - 1];
    }
}
