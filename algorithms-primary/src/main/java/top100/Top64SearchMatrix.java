package top100;

public class Top64SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int L = 0, R = row * col - 1;

        while (L <= R) {
            int mid = ((R - L) >> 1) + L;
            int cr = mid / col;
            int cc = mid % col;
            if (target < matrix[cr][cc]){
                R = mid - 1;
            } else if (target > matrix[cr][cc]){
                L = mid + 1;
            } else{
                return true;
            }
        }
        return false;
    }
}
