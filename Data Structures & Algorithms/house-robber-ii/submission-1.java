class Solution {
    int robb(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
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

        if(n == 1)return nums[0];

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != 0)
                temp1.add(nums[i]);
            if (i != n - 1)
                temp2.add(nums[i]);
        }

        int[] start = new int[n - 1];
        int[] first = new int[n - 1];

        for (int i = 0; i < temp1.size(); i++) {
            start[i] = temp1.get(i);
        }
        for (int i = 0; i < temp2.size(); i++) {
            first[i] = temp2.get(i);
        }

        return Math.max(robb(start), robb(first));
    }
}
