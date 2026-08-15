class Solution {
    int[][] dp;
    int countWays(int i, int amount, int[] coins) {
        if (i == 0) {
            if (amount % coins[i] == 0) {
                return amount / coins[i];
            } else {
                return 1_000_000_000;
            }
        }
        int take = 1_000_000_000;

        if (amount >= coins[i]) {
            take = 1 + countWays(i, amount - coins[i], coins);
        }
        int notake = countWays(i - 1, amount, coins);

        return Math.min(take, notake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        dp = new int[n][amount + 1];

        if (amount == 0) {
            return 0;
        }

        int ans = countWays(n - 1, amount, coins);
        return ans == 1_000_000_000 ? -1 : ans;
    }
}
