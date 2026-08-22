/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) {
            return 0;
        }

        int[] start = new int[n];
        int[] end = new int[n];
        int ans = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        int i = 0;
        int j = 0;
        Arrays.sort(start);
        Arrays.sort(end);

        while (i < n && j < n) {
            if (start[i] < end[j]) {
                ans++;
                i++;
                res = Math.max(res, ans);
            } else {
                j++;
                ans--;
            }
        }
        return res;
    }
}
