class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1]));

        int[][] ans = new int[k][2];

        for (int[] point : points) {
            q.offer(point);
        }
        int i = 0;

        while (k > 0) {
            int[] temp = q.poll();
            ans[i] = temp;
            i++;
            k--;
        }
        return ans;
    }
}
