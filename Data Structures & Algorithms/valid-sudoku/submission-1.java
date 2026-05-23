class Solution {

    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char num = board[row][col];

                // Skip empty cells
                if (num == '.') {
                    continue;
                }

                // Create unique identifiers
                String rowCheck = num + " in row " + row;
                String colCheck = num + " in col " + col;
                String boxCheck = num + " in box " + (row / 3) + "-" + (col / 3);

                // If already exists -> invalid
                if (set.contains(rowCheck) ||
                    set.contains(colCheck) ||
                    set.contains(boxCheck)) {

                    return false;
                }

                // Add to set
                set.add(rowCheck);
                set.add(colCheck);
                set.add(boxCheck);
            }
        }

        return true;
    }
}