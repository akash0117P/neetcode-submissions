class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    int maxi = Math.min(1 + prev[j - 1], 1 + prev[j]);

                    maxi = Math.min(maxi, 1 + cur[j - 1]);
                    cur[j] = maxi;
                }
            }
            prev = cur;
        }
        return prev[m];
    }
}
