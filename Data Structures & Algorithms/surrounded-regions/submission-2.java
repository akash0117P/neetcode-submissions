class Solution {
    int[][] visit;
    int n;
    int m;
    int[] rows = {-1, 0, 1, 0};
    int[] cols = {0, 1, 0, -1};

    void dfs(int row, int col, char[][] board) {
        board[row][col] = '#';

        for (int k = 0; k < 4; k++) {
            int r = row + rows[k];
            int c = col + cols[k];
            if (r >= 0 && r < n && c >= 0 && c < m && board[r][c] == 'O') {
                dfs(r, c, board);
            }
        }
    }

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;

        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O')
                dfs(0, c, board);

            if (board[n - 1][c] == 'O')
                dfs(n - 1, c, board);
        }
        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O')
                dfs(r, 0, board);

            if (board[r][m - 1] == 'O')
                dfs(r, m - 1, board);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }
        return;
    }
}
