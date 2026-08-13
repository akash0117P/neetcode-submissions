class Solution {
    int[] dp;

    int robb(int k, int[] nums) {
        if (k < 0) {
            return 0;
        }
        if (dp[k] != 0)
            return dp[k];

        return dp[k] = Math.max(nums[k] + robb(k - 2, nums), robb(k - 1, nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[nums.length];

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int take = nums[i];
            if (i - 2 >= 0)
                take += prev2;

            int nonTake = prev;

            int cur = Math.max(take, nonTake);

            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}
