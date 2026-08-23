class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int n = intervals.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0;

        for (int q : Arrays.stream(queries).sorted().toArray()) {
            while (i < n && q >= intervals[i][0]) {
                int r = intervals[i][1];
                int l = intervals[i][0];
                pq.offer(new int[] {r - l + 1, r});
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            mp.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }
        int[] res = new int[queries.length];

        for (int j = 0; j < queries.length; j++) {
            res[j] = mp.get(queries[j]);
        }
        return res;
    }
}
