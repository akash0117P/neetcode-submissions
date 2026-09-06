class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];

            if (str.equals("+")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a + b);
                continue;
            }
            if (str.equals("-")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
                continue;
            }
            if (str.equals("*")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a * b);
                continue;
            }
            if (str.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a / b);
                continue;
            }
            st.push(Integer.parseInt(str));
        }
        return st.peek();
    }
}
