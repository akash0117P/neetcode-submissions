class Solution {
    boolean dfs(int i, int j, String s, String p) {
        if (i < 0 && j < 0) {
            return true;
        }

        if (i >= 0 && j < 0) {
            return false;
        }

        if (i < 0) {
            for (int k = 1; k <= j; k += 2) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return j % 2 == 1;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            return dfs(i - 1, j - 1, s, p);
        }

        if (p.charAt(j) == '*') {
            boolean zero = dfs(i, j - 2, s, p);

            boolean more =
                (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dfs(i - 1, j, s, p);

            return zero || more;
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        return dfs(s.length() - 1, p.length() - 1, s, p);
    }
}