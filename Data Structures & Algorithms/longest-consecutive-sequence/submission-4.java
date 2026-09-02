class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        int ans = 0;
        HashSet<Integer> st = new HashSet<>();

        for (int i : nums) {
            st.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!st.contains(nums[i] - 1)) {
                int temp = 0;
                int j = nums[i];

                while (st.contains(j)) {
                    temp++;
                    j = j + 1;
                }
                 ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}
