class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        
        if(s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();

        int i = 0 ;
        int j = 0 ;
        int max = Integer.MIN_VALUE;

        while(i < s.length()){
            if(!st.contains(str[i])){
                st.add(str[i]);
                int cur = st.size();

                if(cur > max){
                    max = cur;
                }
                i++;
            }else{
                st.remove(str[j]);
                j++;
            }
        }
        return max;
    }
}
