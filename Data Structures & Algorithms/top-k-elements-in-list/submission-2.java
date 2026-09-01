class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;

        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] bucket = new List[n + 1];

        for (int i : mp.keySet()) {
            int freq = mp.get(i);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(i);
        }
        int idx = 0;
        int[] ans = new int[k];

        for (int i = n; i >= 0 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int j : bucket[i]) {
                    ans[idx] = j;
                    idx++;

                    if (idx == k)
                        break;
                }
            }
        }
        return ans;
    }
}
