class Solution {
    void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> subset) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i + 1, nums, res, subset);
        subset.remove(subset.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(i + 1, nums, res, subset);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, res, subset);

        return res;
    }
}
