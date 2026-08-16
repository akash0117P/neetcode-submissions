class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 == 1)
            return false;

        int target = sum / 2;

        boolean[] prev = new boolean[target + 1];
        boolean[] cur = new boolean[target + 1];

        prev[0] = cur[0] = true;

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= target; t++) {
                boolean take = false;
                if (t >= nums[i]) {
                    take = prev[t - nums[i]];
                }
                boolean notake = prev[t];
                cur[t] = take || notake;
            }
            prev = cur;
             cur = new boolean[target + 1];
        }
  
        
        return prev[target];
    }
}
