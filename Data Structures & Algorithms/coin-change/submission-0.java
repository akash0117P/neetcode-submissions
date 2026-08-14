class Solution {
    int countWays(int i, int taken, int sum, int amount, int[] coins) {
        if (sum == amount) {
            return taken;
        }
        if (i >= coins.length || sum > amount) {
            return Integer.MAX_VALUE;
        }

        int take = countWays(i, taken + 1, sum + coins[i], amount, coins);
        int notake = countWays(i + 1, taken, sum, amount, coins);

        return Math.min(take, notake);
    }
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int ans = countWays(0, 0, 0, amount, coins);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
