class Solution {
    int n;
    int m;
    boolean dfs(int i, int j, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }

        if (i >= n || i < 0 || j < 0 || j >= m || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean res = dfs(i + 1, j, index + 1, board, word) || dfs(i - 1, j, index + 1, board, word)
            || dfs(i, j + 1, index + 1, board, word) || dfs(i, j - 1, index + 1, board, word);

        board[i][j] = temp;
        return res;
    }
    public boolean exist(char[][] board, String word) {
         n = board.length;
         m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
