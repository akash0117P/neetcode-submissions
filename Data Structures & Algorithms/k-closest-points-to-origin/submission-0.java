class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> Integer.compare((a[0] * a[0] + a[1] * a[1]), (b[0] * b[0] + b[1] * b[1])));

        for (int[] point : points) {
            q.offer(point);
        }

        int[][] res = new int[k][2];

        int i = 0;
        while (k > 0) {
            res[i] = q.poll();
            i++;
            k--;
        }
        return res;
    }
}
