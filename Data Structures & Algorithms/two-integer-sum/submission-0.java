class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
           int k = target - nums[i] ;

           if(mp.containsKey(k))
           {
             int[] ans = {mp.get(k), i };
             return ans;
           }

           mp.put(nums[i], i);
        }
       
       int[] ans1 = {};
       return ans1;

    }
}
