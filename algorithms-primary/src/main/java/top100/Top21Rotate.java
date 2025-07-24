package top100;

public class Top21Rotate {

    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return;
        }
        int rL = 0, cL = 0;
        int rR = matrix[0].length - 1, cR = matrix.length - 1;

        while (rL < rR) {
            swapData(matrix, rL++, rR--, cL++, cR--);
        }

    }

    private static void swapData(int[][] matrix, int rowL, int rowR, int colL, int colR) {
        int temp = 0;
        for (int i = 0; i < rowR - rowL; i++) {
            temp = matrix[rowL][colL + i];
            System.out.println(temp);
            matrix[rowL][colL + i] = matrix[rowR-i][colL];//?rowL
            matrix[rowR-i][colL] = matrix[colR][rowR-i];
            matrix[colR][rowR-i] = matrix[colL+i][rowR];
            matrix[colL+i][rowR] = temp;
            /**
             * 0,0 0,1 0,2 0,3
             * 1,0 1,1 1,2 1,3
             * 2,0 2,1 2,2 2,3
             * 3,0 3,1 3,2 3,3
             */

            //1 - matrix[rowL][colL + i]; [0, 1]
            //10 - matrix[colL+i][rowR]; [1,3]
            //12 - matrix[colR][rowR-i]; [3,2]
            //13 - matrix[rowR-i][colL]; [2, 0]

//            matrix[rowR - i][colL] = matrix[rowR][rowR];
//            matrix[colR][rowR] = matrix[rowL][rowR];
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
rotate(arr);
    }
}
