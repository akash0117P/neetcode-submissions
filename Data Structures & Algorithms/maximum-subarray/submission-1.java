class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int maxi = Integer.MIN_VALUE;
        int j = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxi = Math.max(maxi, sum);

            while (sum < 0 && j <= i) {
                sum = sum - nums[j];
                j++;
            }
        }
        return maxi;
    }
}
