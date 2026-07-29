class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        if (maxHeap.peek() < num) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        int n = maxHeap.size();
        int m = minHeap.size();

        if (Math.abs(n - m) == 2) {
            if (n > m) {
                minHeap.offer(maxHeap.poll());
            } else {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        int n = maxHeap.size();
        int m = minHeap.size();

        if ((n + m) % 2 == 0) {
            int res = maxHeap.peek() + minHeap.peek();
            return (double) (res / 2.0);
        }

        if (n > m)
            return maxHeap.peek();
        else
            return minHeap.peek();
    }
}
