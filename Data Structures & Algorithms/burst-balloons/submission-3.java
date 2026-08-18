class Solution {
    int[][] dp;
    List<Integer> ans;
    public int maxCoins(int[] nums) {
        ans = new ArrayList<>();
        int n = nums.length;

        dp = new int[n + 2][n + 2];
        ans.add(1);
        for (int i : nums) {
            ans.add(i);
        }
        ans.add(1);

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;
                int mini = Integer.MIN_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int cost = ans.get(i - 1) * ans.get(ind) * ans.get(j + 1) + dp[i][ind - 1]
                        + dp[ind + 1][j];

                    mini = Math.max(cost, mini);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][n];
    }
}
