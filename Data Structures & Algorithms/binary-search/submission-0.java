class Solution {
    int search(int[] nums, int l, int r, int k) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;

        if (nums[mid] == k)
            return mid;

        if (nums[mid] > k) {
            return search(nums, l, mid - 1, k);
        } else {
            return search(nums, mid + 1, r, k);
        }
    }
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }
}
