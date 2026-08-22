class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        res.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] cur = res.getLast();

            if (cur[1] >= intervals[i][0]) {
                cur[0] = Math.min(cur[0], intervals[i][0]);
                cur[1] = Math.max(cur[1], intervals[i][1]);
                res.removeLast();
                res.add(cur);
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[0][]);
    }
}
