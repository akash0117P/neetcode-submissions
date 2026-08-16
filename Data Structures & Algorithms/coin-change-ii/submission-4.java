class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] cur = new int[amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                prev[t] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            cur = new int[amount + 1];
            cur[0] = 1;
            for (int t = 1; t <= amount; t++) {
                int take = 0;
                if (coins[i] <= t) {
                    take = cur[t - coins[i]];
                }
                int notake = prev[t];
                cur[t] = take + notake;
            }
            prev = cur;
        }
        return prev[amount];
    }
}
