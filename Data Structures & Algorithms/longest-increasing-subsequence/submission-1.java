class Solution {
    int[][] dp;
    int dfs(int i, int prev, int[] nums) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][prev + 1] != -1) {
            return dp[i][prev+1];
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
        dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, -1, nums);
    }
}
