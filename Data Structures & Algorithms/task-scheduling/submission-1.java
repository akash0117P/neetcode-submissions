class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        for (int i : freq) {
            if (i > 0) {
                maxheap.offer(i);
            }
        }

        int time = 0;

        while (!maxheap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (maxheap.isEmpty()) {
                time = queue.peek()[1];
            } else {
                int cnt = maxheap.poll() - 1;
                if (cnt > 0) {
                    queue.offer(new int[] {cnt, time + n});
                }
            }

            if (!queue.isEmpty() && time == queue.peek()[1]) {
                maxheap.offer(queue.peek()[0]);
                queue.poll();
            }
        }
        return time;
    }
}
