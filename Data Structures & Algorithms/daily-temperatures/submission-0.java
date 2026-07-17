class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];

            while (!st.isEmpty() && temp > temperatures[st.peek()]) {
                int j = st.pop();
                res[j] = i - j;
            }
            st.push(i);
        }
        return res;
    }
}
