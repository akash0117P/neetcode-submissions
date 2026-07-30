class Solution {
    void dfs(int[] nums, Map<Integer, Integer> mp, List<List<Integer>> res, List<Integer> ans) {
        if (ans.size() == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!mp.containsKey(i)) {
                mp.put(i, 1);
                ans.add(nums[i]);
                dfs(nums, mp, res, ans);
                mp.remove(i);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> mp = new HashMap<>();
        dfs(nums, mp, res, ans);

        return res;
    }
}
