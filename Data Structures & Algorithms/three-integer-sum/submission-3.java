class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        Set<List<Integer>> st = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                long sum = nums[i] + nums[l];
                sum += nums[r];

                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                    st.add(temp);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return new ArrayList<>(st);
    }
}
