class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int j = st.pop();
                ans[j] = i - j;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int j = st.pop();
            ans[j] = 0;
        }
        return ans;
    }
}
