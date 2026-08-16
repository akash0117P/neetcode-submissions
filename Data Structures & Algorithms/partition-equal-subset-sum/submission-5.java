class Solution {
    Boolean[][] dp;
    boolean dfs(int i, int sum, int[] nums) {
        if (sum == 0)
            return true;
        if (i == 0 ) {
            return nums[i] == sum;
        }
        if (i < 0) {
            return false;
        }

        if (dp[i][sum] != null) {
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
        dp = new Boolean[n][(sum / 2) + 1];

        return dfs(n - 1, sum / 2, nums);
    }
}
