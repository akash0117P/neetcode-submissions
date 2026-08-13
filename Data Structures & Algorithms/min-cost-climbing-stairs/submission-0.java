class Solution {
    int[] dp;
    int n;
    int climb(int k, int[] cost) {
        if (k >= n) {
            return 0;
        }

        if (dp[k] != 0) {
            return dp[k];
        }

        return dp[k] = cost[k] + Math.min(climb(k + 1, cost), climb(k + 2, cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[cost.length];
        return Math.min(climb(0, cost), climb(1, cost));
    }
}
