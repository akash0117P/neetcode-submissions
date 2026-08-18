class Solution {
    boolean dfs(int i, int j, String s, String p) {
        if (i < 0 && j < 0) {
            return true;
        }

        if (i >= 0 && j < 0) {
            return false;
        }

        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k=k+2) {
                if (k + 1 > j ||p.charAt(k+1) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            return dfs(i - 1, j - 1, s, p);
        } else {
            if (p.charAt(j) == '*') {
                boolean zero = dfs(i, j - 2, s, p);

                boolean more = (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    && dfs(i - 1, j, s, p);

                return zero || more;
            }
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return dfs(n - 1, m - 1, s, p);
    }
}
