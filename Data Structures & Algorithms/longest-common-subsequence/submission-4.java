class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m];

        if (text1.charAt(0) == text2.charAt(0)) {
            prev[0] = 1;
        }

        for (int j = 1; j < m; j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                prev[j] = 1;
            } else {
                prev[j] = prev[j - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            int[] cur = new int[m];
            if (text1.charAt(i) == text2.charAt(0)) {
                cur[0] = 1;
            } else {
                cur[0] = prev[0];
            }
            for (int j = 1; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }
            prev = cur;
        }

        return prev[m - 1];
    }
}
