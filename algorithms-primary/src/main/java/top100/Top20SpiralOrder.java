package top100;

import java.util.ArrayList;
import java.util.List;

public class Top20SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int aL = 0, bL = matrix[0].length - 1;
        int cH = 0, dH = matrix.length - 1;
        List<Integer> ans = new ArrayList<>();
        while (aL <= bL && cH <= dH) {
            System.out.println(aL + " " + bL + " " + cH + " " + dH);
            addLine(matrix, ans, aL++, bL--, cH++, dH--);
        }
        return ans;
    }

    private static void addLine(int[][] matrix, List<Integer> ans, int a, int b, int c, int d) {
        if (a == b) {
            for (int i = c; i <= d; i++) {
                ans.add(matrix[i][a]);
            }
        } else if (c == d) {
            for (int i = a; i <= b; i++) {
                ans.add(matrix[c][i]);
            }
        } else {
            int currA = a;
            int currC = c;
            while (currA != b) {
                ans.add(matrix[a][currA]);
                currA++;
            }
            while (currC != d) {
                ans.add(matrix[currC][b]);
                currC++;
            }
            while (b != a) {
                ans.add(matrix[d][b]);
                b--;
            }
            while (d != c) {
                ans.add(matrix[d][c]);
                d--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        //[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
        //1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
//        System.out.println(spiralOrder(matrix));
//        //[[1,2,3],[4,5,6],[7,8,9]]
//        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(spiralOrder(matrix));
        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
        //
//        测试用例:[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//        测试结果:[1,2,3,3,7,12,11,10,9,5,6,7]
//        [1, 2, 3, 3, 7, 12, 11, 10, 9, 5, 6, 7]
//        期望结果:[1,2,3,4,8,12,11,10,9,5,6,7]

    }
}
