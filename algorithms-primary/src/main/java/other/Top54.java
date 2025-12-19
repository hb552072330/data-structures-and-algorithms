package other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhanghongbing
 * @Date 2025-11-22 18:57
 **/
public class Top54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int a = 0, b = n - 1;
        int c = m - 1, d = 0;
        while (a <= b && d <= c) {
            addLine(matrix, ans, d++, c--, a++, b--);
        }
        return ans;
    }

    // a=0,0 b=0,1 a起点 b行终点
    // d=2,0 c=2,1 c列终点 d列起点
    private void addLine(int[][] matrix, List<Integer> ans, int d, int c, int a, int b) {
        if (a == b) {
            while (d <= c) {
                ans.add(matrix[d++][a]);
            }
        } else if (d == c) {
            while (a <= b) {
                ans.add(matrix[d][a++]);
            }
        } else {
            //最高行
            int l = a;
            while (l <= b) {
                ans.add(matrix[d][l++]);
            }
            //最右列
            int top = d + 1;
            while (top <= c) {
                ans.add(matrix[top++][b]);
            }
            //最下行
            int r = b - 1;
            while (r >= a) {
                ans.add(matrix[c][r--]);
            }
            //最左列
            int bot = c - 1;
            while (bot > d) {
                ans.add(matrix[bot--][a]);
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
        System.out.println(new Top54().spiralOrder(matrix));
        //
//        测试用例:[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//        测试结果:[1,2,3,3,7,12,11,10,9,5,6,7]
//        [1, 2, 3, 3, 7, 12, 11, 10, 9, 5, 6, 7]
//        期望结果:[1,2,3,4,8,12,11,10,9,5,6,7]

    }
}
