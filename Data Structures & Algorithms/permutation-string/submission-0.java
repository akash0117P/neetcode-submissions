class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];

        for(int i = 0 ; i < s1.length() ; i++){
            arr[s1.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < s2.length() ; i++){
                int j = i;
                int[] cur = new int[26];
            
                while(j < s2.length() && arr[s2.charAt(j) - 'a'] != 0){
                    cur[s2.charAt(j)- 'a']++;
                    if(Arrays.equals(arr, cur)){
                        return true;
                    }
                    j++;
                }    
        }
        return false;
    }
}
