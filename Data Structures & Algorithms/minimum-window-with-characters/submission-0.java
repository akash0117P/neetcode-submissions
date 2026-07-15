class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();

        if(n < m){
            return "";
        }
        Map<Character,Integer> mp = new HashMap<>();

        for(char ch : t.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1 );
        }

        int start = -1 ; 
        int l = 0;
        int min = Integer.MAX_VALUE;
        int r = 0;
        int cnt =  0;

        while(r < n){
            
            char ch = s.charAt(r);

         if (mp.getOrDefault(ch, 0) > 0) {
                cnt++;
            }

            mp.put(ch, mp.getOrDefault(ch, 0) - 1);

            while(cnt == m){
                if((r - l + 1) < min ){
                    min = r - l + 1 ;
                    start = l ;
                }

                mp.put(s.charAt(l) , mp.getOrDefault(s.charAt(l), 0) + 1);

                if(mp.get(s.charAt(l)) > 0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
   
      if(start == -1 ) return "";

      return s.substring(start , start + min);
    }
}
