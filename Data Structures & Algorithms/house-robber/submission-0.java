class Solution {
    int[] dp;
    int rob(int k, int[] nums) {
        if (k >= nums.length) {
            return 0;
        }
        if (dp[k] != 0)
            return dp[k];

        return dp[k] = Math.max(nums[k] + rob(k + 2, nums), rob(k + 1, nums));
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        return Math.max(rob(0, nums), rob(1, nums));
    }
}
