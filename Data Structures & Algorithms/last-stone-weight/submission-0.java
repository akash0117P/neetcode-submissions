class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) {
            q.offer(i);
        }

        while (q.size() > 1) {
            int x = q.poll();
            int y = q.poll();

            int ans = Math.abs(x - y);

            if (ans == 0 && q.size() == 0) {
                return 0;
            }

            if (ans != 0) {
                q.offer(ans);
            }
        }
        return q.peek();
    }
}
