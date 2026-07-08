class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int i = 0 ;
        int j = s.length() - 1;

        char[] ch = s.toCharArray();

        while(i <= j){
            if(ch[i] != ch[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
