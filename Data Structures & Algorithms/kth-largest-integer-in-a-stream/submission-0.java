class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
    }

    public int add(int val) {
        pq.offer(val);
        int l = pq.size() - k;

        while (l > 0) {
            pq.poll();
            l--;
        }

        if (pq.size() > 0)
            return pq.peek();
        return 0;
    }
}
