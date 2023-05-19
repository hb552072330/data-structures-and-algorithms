package cn.baymax.mac04;

import java.util.Arrays;
//https://leetcode.cn/problems/russian-doll-envelopes/
//354
public class Code04_EnvelopesProblem {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o2[1]);
        int[] ends = new int[envelopes.length];
        ends[0] = envelopes[0][1];
        int right = 0;
        //[[5,4],[6,4],[6,7],[2,3]]
        // 3
        for (int i = 0; i < envelopes.length; i++) {
            int l = 0;
            int r = right;
            while (l <= r) {
                int m = (l + r) / 2;
                if (ends[m] >= envelopes[i][1]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            right = Math.max(l, right);
            ends[l] = envelopes[i][1];
        }
        return right + 1;

    }

}
