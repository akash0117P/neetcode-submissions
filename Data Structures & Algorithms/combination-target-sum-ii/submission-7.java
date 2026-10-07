class Solution {
    void dfs(int i, int[] candidates, int sum, int target, List<List<Integer>> res,
        List<Integer> subset) {
        if (sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }

        if (sum > target || i == candidates.length) {
            return;
        }
        subset.add(candidates[i]);
        dfs(i + 1, candidates, sum + candidates[i], target, res, subset);
        subset.remove(subset.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        dfs(i + 1, candidates, sum, target, res, subset);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, 0, target, res, subset);
        return res;
    }
}
