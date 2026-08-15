class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int maxi = 0;
        int preff = 1;
        int suff = 1;

        for (int i = 0; i < n; i++) {
            if (suff == 0)
                suff = 1;
            if (preff == 0)
                preff = 1;

            suff = suff * nums[i];
            preff = preff * nums[n - i - 1];

            maxi = Math.max(maxi, Math.max(preff, suff));
        }
        return maxi;
    }
}
