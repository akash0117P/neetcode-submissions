class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int prevEnd = intervals[0][1];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (prevEnd > intervals[i][0]) {
                ans++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return ans;
    }
}
