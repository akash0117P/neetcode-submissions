class MinStack {
     Stack<Integer> st ;
     Stack<Integer> min;

    public MinStack() {
         st = new Stack<>();
         min = new Stack<>();
    }

    public void push(int val) {
        st.push(val);

        if(!min.isEmpty()){
            int k = min.peek();

            if(k > val){
                min.push(val);
            }else{
                min.push(k);
            }
        }else{
            min.push(val);
        }
    }

    public void pop() {
        st.pop();
        min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
