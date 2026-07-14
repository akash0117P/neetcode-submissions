class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        
        for(int i = 1 ; i < prices.length ; i++){
            int cur = prices[i] - min ;

            if(cur > max ){
                max = cur;
            }
            if(prices[i] < min){
                min = prices[i];
            }
        }

        if(max < 0) return 0;
        return max;
    }
}
