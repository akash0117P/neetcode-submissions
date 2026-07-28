class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();

        for (int i : freq) {
            if (i > 0)
                maxHeap.offer(i);
        }

        int time = 0;
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = queue.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    queue.add(new int[] {cnt, time + n});
                }
            }

            if (!queue.isEmpty() && time == queue.peek()[1]) {
                maxHeap.offer(queue.peek()[0]);
                queue.poll();
            }
        }
        return time;
    }
}
