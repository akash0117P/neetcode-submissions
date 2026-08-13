class Solution {
    int robb(int[] nums, int start, int end) {
        int prev = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int take = nums[i];
            if (i - 2 >= 0)
                take += prev2;
            int nonTake = prev;

            int cur = Math.max(take, nonTake);

            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        return Math.max(robb(nums, 0, n - 2), robb(nums, 1, n - 1));
    }
}
