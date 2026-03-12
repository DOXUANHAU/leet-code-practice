package array;

public class ValidSudoku {

     public boolean isValidSudoku(char[][] board) {

    // row[i][num] -> number num already appeared in row i
    boolean[][] row = new boolean[9][9];

    // col[j][num] -> number num already appeared in column j
    boolean[][] col = new boolean[9][9];

    // box[k][num] -> number num already appeared in 3x3 box k
    boolean[][] box = new boolean[9][9];

    // Traverse the whole sudoku board only once
    for (int i = 0; i < 9; i++) {

        for (int j = 0; j < 9; j++) {

            // Skip empty cell
            if (board[i][j] == '.') {
                continue;
            }

            // Convert char '1'..'9' to index 0..8
            int num = board[i][j] - '1';

            // Calculate which 3x3 box this cell belongs to
            // Example:
            // (0,0) -> box 0
            // (4,5) -> box 4
            // (8,8) -> box 8
            int boxIndex = (i / 3) * 3 + (j / 3);

            // If number already appeared in row, column, or box -> invalid
            if (row[i][num] || col[j][num] || box[boxIndex][num]) {
                return false;
            }

            // Mark number as seen in row, column, and box
            row[i][num] = true;
            col[j][num] = true;
            box[boxIndex][num] = true;
        }
    }

    // If no conflict found, sudoku board is valid
    return true;
}
}