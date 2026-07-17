class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        Stack<Double> st = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] p : pair) {
            double time = (double)(target - p[0]) / p[1];
            st.push(time);

            while (st.size() >= 2 && st.peek() <= st.get(st.size() - 2)) {
                st.pop();
            }
        }
        return st.size();
    }
}
