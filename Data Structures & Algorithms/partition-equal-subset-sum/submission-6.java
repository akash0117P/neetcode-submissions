class Solution {
    boolean[][] dp;
    boolean dfs(int i, int sum, int[] nums) {
        if (sum == 0)
            return true;
        if (i == 0) {
            return nums[i] == sum;
        }
        if (i < 0) {
            return false;
        }

        if (dp[i][sum] != false) {
            return dp[i][sum];
        }

        boolean take = false;

        if (sum >= nums[i]) {
            take = dfs(i - 1, sum - nums[i], nums);
        }
        boolean notake = dfs(i - 1, sum, nums);

        return dp[i][sum] = take || notake;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 == 1)
            return false;

        int target = sum / 2;
        dp = new boolean[n][target + 1];
        dp[0][0] = true;

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                boolean take = false;
                if (t >= nums[i]) {
                    take = dp[i - 1][t - nums[i]];
                }
                boolean notake = dp[i - 1][t];
                dp[i][t] = take || notake;
            }
        }

        return dp[n - 1][target];
    }
}
