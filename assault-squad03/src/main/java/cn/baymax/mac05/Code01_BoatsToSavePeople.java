package cn.baymax.mac05;

import java.util.Arrays;

//https://leetcode.cn/problems/boats-to-save-people/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
//881
public class Code01_BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int sum = 0;
        int ans = 0;
        while (l <= r) {
            sum = l == r ? people[l] : people[l] + people[r];
            if (sum > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            ans++;
        }
        return ans;
    }
}
