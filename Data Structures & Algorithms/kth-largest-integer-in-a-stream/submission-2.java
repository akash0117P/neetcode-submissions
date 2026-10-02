class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            pq.offer(i);
        }
    }

    public int add(int val) {
        pq.offer(val);

        int rem = pq.size() - k;
        while (rem > 0) {
            pq.poll();
            rem--;
        }
        return pq.peek();
    }
}
