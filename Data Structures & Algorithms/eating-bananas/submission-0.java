class Solution {
    int cal(int[] piles, int h) {
        int hour = 0;
        for (int i = 0; i < piles.length; i++) {
            hour += (int) Math.ceil((double) piles[i] / h);
        }
        return hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int temp = cal(piles, mid);

            if (temp > h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
