class Solution {
    void dfs(int i, int[] nums, int sum, int target, List<List<Integer>> res, List<Integer> cur) {
        if (sum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (i >= nums.length || sum > target) {
            return;
        }

        cur.add(nums[i]);
        dfs(i, nums, sum + nums[i], target, res, cur);
        cur.remove(cur.size() - 1);
        dfs(i + 1, nums, sum, target, res, cur);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, nums, 0, target, res, subset);
        return res;
    }
}
