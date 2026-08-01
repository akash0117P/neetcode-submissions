class Solution {
    boolean canBe(int row, int col, int n, List<String> ans) {
        int c = col-1;

        while (c >= 0) {
            if (ans.get(row).charAt(c) == 'Q') {
                return false;
            }
            c--;
        }

        int dupRow = row;
        int dupCol = col;
        while (dupRow >= 0 && dupCol >= 0) {
            if (ans.get(dupRow).charAt(dupCol) == 'Q') {
                return false;
            }
            dupRow--;
            dupCol--;
        }

        int dupRow1 = row;
        int dupCol1 = col;
        while (dupRow1 < n && dupCol1 >= 0) {
            if (ans.get(dupRow1).charAt(dupCol1) == 'Q') {
                return false;
            }
            dupRow1++;
            dupCol1--;
        }
        return true;
    }
    void dfs(int col, int n, List<String> ans, List<List<String>> res) {
        if (col >= n) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canBe(i, col, n, ans)) {
                String temp = ans.get(i);
                temp = temp.substring(0, col) + 'Q' + temp.substring(col + 1);
                ans.set(i, temp);
                dfs(col + 1, n, ans, res);
                String temp1 = ans.get(i);
                temp1 = temp1.substring(0, col) + '.' + temp1.substring(col + 1);
                ans.set(i, temp1);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        String s = ".".repeat(n);

        for (int i = 0; i < n; i++) {
            ans.add(s);
        }
        dfs(0, n, ans, res);
        return res;
    }
}
