class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            a1 = Math.max(a1, triplet[0]);
            a2 = Math.max(a2, triplet[1]);
            a3 = Math.max(a3, triplet[2]);
        }

        return a1 == target[0] && a2 == target[1] && a3 == target[2];
    }
}
