class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0 ;
        int j = n - 1 ;
        int ans = 0 ;

        while(i < j){
           int k = (j-i) * Math.min(heights[i],heights[j]);

            if(ans < k){
                ans = k;
            }

            if(heights[i] > heights[j])
            {
                j--;
            }else{
                i++;
            }
        }
        return ans;
    }
}
