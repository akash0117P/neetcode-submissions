class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxi = 1;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
             maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}
