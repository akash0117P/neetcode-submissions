class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxi = Integer.MIN_VALUE;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int ele = heights[st.peek()];
                st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                maxi = Math.max(maxi, ele * (i - pse - 1));
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int nse = n;
            int ele = heights[st.peek()];
            st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxi = Math.max(maxi, ele * (n - pse - 1));
        }
        return maxi;
    }
}
