class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        int l = 0;
        int r = n - 1;
        int leftmax = 0;
        int rightmax = 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                if (leftmax > height[l]) {
                    ans += leftmax - height[l];
                } else {
                    leftmax = height[l];
                }
                l++;
            } else {
                if (rightmax > height[r]) {
                    ans += rightmax - height[r];
                } else {
                    rightmax = height[r];
                }
                r--;
            }
        }
        return ans;
    }
}
