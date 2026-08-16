class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int nextSell = 0;
        int nextBuy = 0;
        int next2Buy = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            int curBuy = Math.max(-prices[i] + nextSell, nextBuy);
            int curSell = Math.max(prices[i] + next2Buy, nextSell);
            next2Buy = nextBuy;
            nextBuy = curBuy;
            nextSell = curSell;
        }

        return nextBuy;
    }
}
