package cn.baymax.mac01;

/**
 * leetcode 875  注意Integer.MAX_VALUE问题
 * https://leetcode.cn/problems/koko-eating-bananas/
 */
public class Code05_KoKoEatingBananas {
    /**
     * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉
     * 警卫已经离开了，将在H小时后回来
     * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）
     * 每个小时，她将会选择一堆香蕉，从中吃掉 K 根
     * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉
     * 然后这一小时内不会再吃更多的香蕉。
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉
     * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）
     */


    /**
     * 5
     * 1 2 3
     * 2 7 6
     * 1 2 3
     * 2 3 6
     */

    public static int minEatingSpeed(int[] piles, int h) {
        int ans = 0;
        int L = 1;
        int R = 0;
        for (int pile : piles) {
            R = Math.max(pile, R);
        }

        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            System.out.println("mid： " + mid);
            if (hours2(piles, mid) <= h) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return ans;
    }

    public static long hours(int[] piles, int speed) {
        long ans = 0;
        int offset = speed - 1;
        for (int pile : piles) {
            ans += (pile + offset) / speed;
        }
        return ans;
    }

    // todo 必须用long这个边界问题
    public static long hours2(int[] piles, int speed) {
        long ans = 0;
        for (int pile : piles) {
            ans += (pile - 1 +  speed ) / speed;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println((7 + 3 - 1) / 3);
        System.out.println((6 + 3 - 1) / 3);
        System.out.println((4 + 3 - 1) / 3);
        System.out.println((3 + 3 - 1) / 3);
        //[805306368,805306368,805306368]
        //1000000000
        int[] arr = new int[]{805306368, 805306368, 805306368};
        int h = 1000000000;
        System.out.println("------------------");
        System.out.println(minEatingSpeed(arr, h));
    }
}
