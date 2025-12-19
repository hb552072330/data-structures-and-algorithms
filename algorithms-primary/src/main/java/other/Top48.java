package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 20:16
 **/
public class Top48 {
    public void rotate(int[][] matrix) {
        // 0,0 0,1 0,2  0,3
        // 1,0 1,1 1,2  1,3
        // 2,0 2,1 3,2  2,3
        // 3,0 3,1 3,2  3,3
        // a 行起点 b 行终点
        // c 列起点 d列终点
        int a = 0, b = matrix.length - 1;
        int c = 0, d = matrix.length - 1;
        while (a < b) {
            swap(matrix, a, b, c, d);
            a++;
            b--;
            c++;
            d--;
        }
    }

    public void swap(int[][] matrix, int a, int b, int c, int d) {
        for (int i = 0; i < b - a; i++) {
            int temp = matrix[a][c + i];
            matrix[a][c + i] = matrix[b - i][c];
            matrix[b - i][c] = matrix[b][d - i];
            matrix[b][d - i] = matrix[a + i][d];
            matrix[a + i][d] = temp;
        }
    }
}
