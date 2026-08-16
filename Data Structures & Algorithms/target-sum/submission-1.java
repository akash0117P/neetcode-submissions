class Solution {
    Integer[][] dp;
    int offset;
    int dfs(int i, int sum, int target, int[] nums) {
        if (i < 0) {
            return sum == target ? 1 : 0;
        }

        if (dp[i][sum + offset] != null) {
            return dp[i][sum + offset];
        }

        int sub = dfs(i - 1, sum - nums[i], target, nums);
        int add = dfs(i - 1, sum + nums[i], target, nums);
        return dp[i][sum + offset] = add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (Math.abs(target) > total) {
            return 0;
        }
        offset = total;
        dp = new Integer[n][2 * total + 1];
        return dfs(n - 1, 0, target, nums);
    }
}
