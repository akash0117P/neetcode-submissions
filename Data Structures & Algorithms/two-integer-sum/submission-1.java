class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
           int k = target - nums[i] ;

           if(mp.containsKey(k))
           {
             return new int[] {mp.get(k), i };
           }

           mp.put(nums[i], i);
        }
       return new int[0];

    }
}
