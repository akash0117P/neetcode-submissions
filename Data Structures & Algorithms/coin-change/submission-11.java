class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] cur = new int[amount + 1];

        if (amount == 0) {
            return 0;
        }

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i / coins[0];
            } else {
                prev[i] = 1_000_000_000;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {
                int take = 1_000_000_000;
                if (t >= coins[i]) {
                    take = 1 + cur[t - coins[i]];
                }
                int notake = prev[t];
                cur[t] = Math.min(take, notake);
            }
            prev = cur;
        }

        int ans = prev[amount];
        return ans == 1_000_000_000 ? -1 : ans;
    }
}
