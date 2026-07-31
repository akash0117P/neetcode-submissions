class Solution {
    void dfs(int i, int[] nums, Set<List<Integer>> res, List<Integer> subset) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i + 1, nums, res, subset);
        subset.remove(subset.size() - 1);
        dfs(i + 1, nums, res, subset);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, res, subset);

        for (List<Integer> ls : res) {
            ans.add(ls);
        }
        return ans;
    }
}
