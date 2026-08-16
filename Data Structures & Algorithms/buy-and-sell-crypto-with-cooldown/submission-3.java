class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] prev = new int[2];
        int[] prev2 = new int[2];
        int[] cur=new int[2];
        for (int i = n - 1; i >= 0; i--) {
            cur = new int[2];
            cur[1] = Math.max(-prices[i] + prev[0], prev[1]);
            cur[0] = Math.max(prices[i] + prev2[1], prev[0]);
            prev2 = prev;
            prev = cur;
        }

        return cur[1];
    }
}
