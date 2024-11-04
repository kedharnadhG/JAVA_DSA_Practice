public class nQueenProblem {

    public static void printSolution(int[][] board, int n) {
        for (int[] x : board) {
            for (int v : x) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int column, int n) {
        int i, j;

        // check for the row on the left side
        for (i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // check for upper diagonal on left side
        for (i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check lower diagonal on right side
        for (i = row, j = column; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solvenQueen(int[][] board, int n, int column) {
        /**
         * Base-Case - if all the queens have got placed then return true
         **/

        if (column >= n) {
            return true;
        }

        // consider this column and try placing all the queens one by one in all the
        // rows
        for (int i = 0; i <n; i++) {
            // check if it is safe to place the queen or not
            if (isSafe(board, i, column, column) == true) {
                // place queen in the board
                board[i][column] = 1;

                // recursive call for remaining queens
                if (solvenQueen(board, n, column + 1) == true) {
                    return true;
                }

                // if placing the queen doesn't lead to the solution then backtrack
                board[i][column] = 0;
            }
        }
        // if it is not possible to place the queen in any row of the given column then
        // false
        return false;
    }

    public static void main(String[] args) {

        int[][] board = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };
        if (solvenQueen(board, board.length, 0) == true) {
            printSolution(board, board.length);
        } else {
            System.out.println("Solution doesn't exist");
        }
    }
}
