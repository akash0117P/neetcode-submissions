class Solution {

    public String encode(List<String> strs) {
      String ans = "";

        for(String str : strs){
        
            ans+=str.length();
            ans+= "#";
            ans+=str ;
        }

       System.out.println(ans);
      return ans;
    }

    public List<String> decode(String str) {
  
        List<String> ans = new ArrayList<>();
        int i = 0 ;

        while(i < str.length())
        {
            int hash = str.indexOf("#" , i);

            String s = str.substring(i,hash);

            int len = Integer.parseInt(s);

            String s1 = str.substring(hash + 1 , hash + 1 + len);
            ans.add(s1);

            i = hash + len + 1 ;
        }

     return ans;
    }
}
