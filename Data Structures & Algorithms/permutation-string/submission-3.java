class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        int[] cur = new int[26];
        int window = s1.length();

        if (window > s2.length())
            return false;

        for (char ch : s1.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (int i = 0; i < window; i++) {
            cur[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cur, arr)) {
            return true;
        }
        for (int i = window; i < s2.length(); i++) {
            cur[s2.charAt(i) - 'a']++;

            cur[s2.charAt(i - window) - 'a']--;

            if (Arrays.equals(cur, arr)) {
                return true;
            }
        }

        return false;
    }
}
