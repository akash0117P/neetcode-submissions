class Solution {
    int cal(int[] piles, int h) {
        int temp = 0;
        for (int i : piles) {
            temp += Math.ceil((double) i / h);
        }
        return temp;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i : piles) {
            high = Math.max(high, i);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            int ans = cal(piles, mid);

            if (ans > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
