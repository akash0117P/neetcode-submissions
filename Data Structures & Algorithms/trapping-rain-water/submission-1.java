class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int prefixMax = height[0];
        int[] suffix = new int[n];

        suffix[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, height[i]);
            ans += Math.min(prefixMax, suffix[i]) - height[i];
        }
        return ans;
    }
}
