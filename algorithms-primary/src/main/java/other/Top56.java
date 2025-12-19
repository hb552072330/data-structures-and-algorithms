package other;

import java.util.Arrays;

/**
 * @Author zhanghongbing
 * @Date 2025-11-18 22:54
 **/
public class Top56 {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int idx = 0;
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] < max) {
                max = Math.max(interval[1], max);
                intervals[idx][1] = max;
            } else {
                intervals[idx][0] = min;
                intervals[idx++][1] = max;
                min = interval[0];
                max = interval[1];
            }
        }
        intervals[idx][0] = min;
        intervals[idx][1] = max;
        return Arrays.copyOf(intervals, idx + 1);
    }

    public static void main(String[] args) {
        //ÊäÈë£ºintervals = [[1,3],[2,6],[8,10],[15,18]]
//Êä³ö£º[[1,6],[8,10],[15,18]]
        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(arr);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
