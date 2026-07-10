class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       int n = nums.length;

        Set<List<Integer>> st = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

       for(int i = 0 ; i < n - 2 ;i++){

         if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
        int j = i + 1;
        int k = n - 1 ;

        while( j < k)
        {
            int ans = nums[i] + nums[j] + nums[k];

            if(ans < 0)
            {
                j++;
            }else if(ans > 0 ){
                k--;
            }else{
                st.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
                j++;
                k--;
            }
        }
       }

        return new ArrayList<>(st);
    }
}
