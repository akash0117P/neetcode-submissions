class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0, resLen = 1;
        int n = s.length();

        for (int j = 0; j < n; j++) {
            int l = j;
            int r = j;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    resIdx = l;
                }
                l--;
                r++;
            }
            l = j;
            r = j + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    resIdx = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(resIdx, resLen + resIdx);
    }
}
