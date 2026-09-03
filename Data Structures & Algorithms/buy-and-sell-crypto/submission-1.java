class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int mini = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - mini;
            ans = Math.max(ans, temp);
            mini = Math.min(mini, prices[i]);
        }
        return ans;
    }
}
