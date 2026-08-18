class Solution {
    int[][] dp;
    List<Integer> ans;
    int dfs(int i, int j, List<Integer> nums) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int mini = Integer.MIN_VALUE;

        for (int ind = i; ind <= j; ind++) {
            int cost = nums.get(i - 1) * nums.get(ind) * nums.get(j + 1) + dfs(i, ind - 1, nums)
                + dfs(ind + 1, j, nums);

            mini = Math.max(cost, mini);
        }
        return dp[i][j] = mini;
    }
    public int maxCoins(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;

        dp = new int[n + 1][n + 1];
        ans.add(1);
        for (int i : nums) {
            ans.add(i);
        }
        ans.add(1);

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(1, n, ans);
    }
}
