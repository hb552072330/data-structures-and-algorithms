package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 20:54
 **/
public class Top240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return ans;
    }
}
