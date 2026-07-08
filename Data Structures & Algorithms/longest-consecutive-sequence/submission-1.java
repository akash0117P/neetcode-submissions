class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        return 0;

        HashSet<Integer> st = new HashSet<>();
        int k = 1 ;
        for(int i : nums)
        {
            st.add(i);
        }

        for(int i = 0 ; i<nums.length ; i++){
            int res = 0 ;
            int j = nums[i];

            while(st.contains(j)){
                res++;
                j = j + 1 ;
            }
            if(k < res){
              k = res ;
            }
        }
        return k ;
    }
}
