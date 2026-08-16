class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        for (int j = 0; j < n; j++) {
            prev[j] = 1;
        }

        for (int i = 1; i < m; i++) {
            int[] cur = new int[n];
            cur[0] = 1;
            for (int j = 1; j < n; j++) {
                int top = prev[j];
                int left = cur[j - 1];
                cur[j] = top + left;
            }
            prev = cur;
        }
        return prev[n - 1];
    }
}
