public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length, COLS = board[0].length;
        List<String> res = new ArrayList<>();

        for (String word : words) {
            boolean flag = false;
            for (int r = 0; r < ROWS && !flag; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (board[r][c] != word.charAt(0)) continue;
                    if (backtrack(board, r, c, word, 0)) {
                        res.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int i) {
        if (i == word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length ||
            c >= board[0].length || board[r][c] != word.charAt(i))
            return false;

        board[r][c] = '*';
        boolean ret = backtrack(board, r + 1, c, word, i + 1) ||
                      backtrack(board, r - 1, c, word, i + 1) ||
                      backtrack(board, r, c + 1, word, i + 1) ||
                      backtrack(board, r, c - 1, word, i + 1);
        board[r][c] = word.charAt(i);
        return ret;
    }
}