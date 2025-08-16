package top100;

public class Top68FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;
        int mid1 = 0;
        int mid2 = 0;
        while (left < right) {
            int i = (right - left) >> 1 + left;
            int j = (m + n + 1) / 2 - i;
            int numsMin1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int numsMax1 = i == m ? Integer.MAX_VALUE : nums1[i];
            int numsMin2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int numsMax2 = j == n ? Integer.MAX_VALUE : nums2[j];
            if (numsMin1 <= numsMax2) {
                mid1 = Math.max(numsMin1, numsMin2);
                mid2 = Math.min(numsMax1, numsMax2);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (mid2 + mid1) / 2.0 : mid1;
    }
}
