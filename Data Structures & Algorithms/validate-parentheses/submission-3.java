class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++ ){
            char str = s.charAt(i) ;

            if( str == '(' || str == '{'  || str == '[' ){
                st.push(str);
            }else{  
                   if(st.isEmpty()) return false;

                    char temp = st.pop();

                    if(str == '}' && temp != '{'){
                        return false;
                    }
                    if(str == ']' && temp != '['){
                        return false;
                    }
                    if(str == ')' && temp != '('){
                        return false;
                    }
                }
        }

        if(!st.isEmpty()) return false;

        return true;
    }
}
