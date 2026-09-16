public class Solution {
    private int res;

    public int totalNQueens(int n) {
        res = 0;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, board);
        return res;
    }

    private void backtrack(int r, char[][] board) {
        if (r == board.length) {
            res++;
            return;
        }
        for (int c = 0; c < board.length; c++) {
            if (isSafe(r, c, board)) {
                board[r][c] = 'Q';
                backtrack(r + 1, board);
                board[r][c] = '.';
            }
        }
    }

    private boolean isSafe(int r, int c, char[][] board) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}