class Solution {
    Set<Integer> st = new HashSet<>();
    
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        if (st.contains(n)) {
            return false;
        }
        st.add(n);

        int sum = 0;
        while (n > 0) {
            int k = n % 10;
            n = n / 10;
            sum += k * k;
        }

        return isHappy(sum);
    }
}
