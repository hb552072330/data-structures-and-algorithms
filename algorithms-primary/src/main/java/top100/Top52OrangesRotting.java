package top100;

import java.util.LinkedList;
import java.util.Queue;

public class Top52OrangesRotting {
    public int orangesRotting(int[][] grid) {
        if (grid == null) return 0;
        //列
        int col = grid[0].length;
        //行
        int row = grid.length;
        boolean hasFlag = false;
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * col + j);
                    hasFlag = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                Integer index = queue.poll();
                int R = index / col;
                int C = index % col;
                //上
                if ((R - 1) >= 0 && grid[R - 1][C] == 1) {
                    grid[R - 1][C] = 2;
                    queue.add((R - 1) * col + C);
                }
                //下
                if ((R + 1) < row && grid[R + 1][C] == 1) {
                    grid[R + 1][C] = 2;
                    queue.add((R + 1) * col + C);
                }
                //左
                if ((C - 1) >= 0 && grid[R][C - 1] == 1) {
                    grid[R][C - 1] = 2;
                    queue.add(R * col + C - 1);
                }
                //右
                if ((C + 1) < col && grid[R][C + 1] == 1) {
                    grid[R][C + 1] = 2;
                    queue.add(R * col + C + 1);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return hasFlag ?  ans - 1:0;
    }
}
