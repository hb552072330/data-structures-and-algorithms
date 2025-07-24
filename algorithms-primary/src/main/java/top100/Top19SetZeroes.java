package top100;


import java.util.Arrays;

public class Top19SetZeroes {
    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // 1 2 0
        // 3 0 1
        // 8 1 1
        boolean colFlag = matrix[0][0] == 0;
        int len = matrix.length;
//        int first = matrix[0][0];
        for (int i = 0; i < len; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
            }
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        matrix[0][0] = 0;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                int idx = 1;
                while (idx < len) {
                    matrix[idx++][i] = 0;
                }
            }
        }
        for (int i = 1; i < len; i++) {
            if (matrix[i][0] == 0) {
                int idx = 1;
                int length = matrix[i].length;
                while (idx < length) {
                    matrix[i][idx++] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (colFlag) {
            for (int i = 0; i < len; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        //输入：matrix = [[1,1,1],[1,0,1],[1,1,1]] 输出：[[1,0,1],[0,0,0],[1,0,1]]
        int[][] arrs = new int[][]{{1},{0}};
//        int[][] arrs = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};
        //	测试用例:[[1],[0]]
        //	测试结果:[[1],[0]]
        //	期望结果:[[0],[0]]
//        printArr(arrs);
        setZeroes(arrs);
        printArr(arrs);

    }

    private static void printArr(int[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            int[] arr = arrs[i];

//            for (int i1 : arr) {
//                System.out.println(i1 + "  ");
//            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("--------------");
    }

}