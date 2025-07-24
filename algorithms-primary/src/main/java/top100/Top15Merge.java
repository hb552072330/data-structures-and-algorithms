package top100;

import java.util.Arrays;

public class Top15Merge {

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        int L = intervals[0][0];
        int R = intervals[0][1];
        int len = intervals.length;
        int idx = 0;
        for (int i = 1; i < len; i++) {
            int currL = intervals[i][0];
            int currR = intervals[i][1];
            if (R < currL) {
                intervals[idx][0] = L;
                intervals[idx++][1] = R;
                L = currL;
                R = currR;
            } else {
                R = Math.max(R, currR);
            }

        }
        intervals[idx][0] = L;
        intervals[idx++][1] = R;
        System.out.println(idx + "   " + Arrays.toString(intervals));
        return Arrays.copyOf(intervals, idx);
    }

    public static void main(String[] args) {
        //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
        int[][] arr = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] merge = merge(arr);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }

    }


}
