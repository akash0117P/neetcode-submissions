class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int res = 0;
        int j = 0;

        for(int i = 0 ; i < s.length() ; i++ ){
            char c = s.charAt(i);
            arr[c-'A']++;

             ans = Math.max(ans,arr[c-'A']);

            while((i - j + 1 - ans) > k){
                arr[s.charAt(j)-'A']--;
                j++;
            }

             res = Math.max(res, i-j+1);
        }
        return res;
    }
}
