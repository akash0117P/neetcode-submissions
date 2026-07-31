class Solution {
    void dfs(int n, int open, int close, String str, List<String> res) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }

        if (open < n) {
            dfs(n, open + 1, close, str + "(", res);
        }

        if (open > close) {
            dfs(n, open, close + 1, str + ")", res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";

        dfs(n, 0, 0, str, res);
        return res;
    }
}
