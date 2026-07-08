class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int n : nums){
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }

        for(int n : mp.keySet()){
            if(mp.get(n) > 1)
            {
                return true;
            }
        }

        return false;

    }
}