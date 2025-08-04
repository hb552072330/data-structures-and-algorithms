package top100;

public class Top60Exist {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (f(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean f(char[][] board, int i, int j, char[] w, int k) {
        if (k == w.length) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
            return false;
        }
        if (board[i][j] != w[k]) {
            return false;
        }
        char temp = board[i][j];
        boolean ans = f(board, i - 1, j, w, k + 1)
                || f(board, i + 1, j, w, k + 1)
                || f(board, i, j + 1, w, k + 1)
                || f(board, i, j - 1, w, k + 1);
        board[i][j] = temp;
        return ans;
    }
}
