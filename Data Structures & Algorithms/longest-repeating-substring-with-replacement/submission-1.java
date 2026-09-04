class Solution {
    public int characterReplacement(String s, int k) {
        int arr[] = new int[26];
        int maxFreq = 0;
        int res = 0;

        int i = 0;
        int j = 0;

        while (i < s.length()) {
            arr[s.charAt(i) - 'A']++;
            maxFreq = Math.max(maxFreq, arr[s.charAt(i) - 'A']);

            while ((i - j + 1 - maxFreq) > k) {
                arr[s.charAt(j) - 'A']--;
                j++;
            }
            res = Math.max(res, i - j + 1);
            i++;
        }
        return res;
    }
}
