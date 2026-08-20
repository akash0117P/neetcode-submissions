class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int card : hand) {
            if (!mp.containsKey(card)) {
                mp.put(card, 1);
                pq.offer(card);
            } else {
                mp.put(card, mp.get(card) + 1);
            }
        }

        while (!pq.isEmpty()) {
            int start = pq.peek();
            int startCount = mp.get(start);
            int size = groupSize - 1;

            if (startCount > 1) {
                mp.put(start, startCount - 1);
            } else {
                mp.remove(start);
                pq.remove(start);
            }

            int card = start + 1;
            while (size > 0) {
                if (!mp.containsKey(card)) {
                    return false;
                }
                int count = mp.get(card);
                if (count - 1 > 0) {
                    mp.put(card, count - 1);
                } else {
                    mp.remove(card);
                    pq.remove(card);
                }
                size--;
                card = card + 1;
            }
        }
        return true;
    }
}
