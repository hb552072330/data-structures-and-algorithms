package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-18 22:10
 **/
public class Top88 {
    public static int[] merge2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m + n];
        int mLeft = 0;
        int nLeft = 0;
        int aLeft = 0;
        while (mLeft < m && nLeft < n) {
            if (nums1[mLeft] > nums2[nLeft]) {
                ans[aLeft++] = nums2[nLeft++];
            } else {
                ans[aLeft++] = nums1[mLeft++];
            }
        }
        while (mLeft < m) {
            ans[aLeft++] = nums1[mLeft++];
        }
        while (nLeft < n) {
            ans[aLeft++] = nums2[nLeft++];
        }
        return ans;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = nums1.length - 1;
        int mMax = m - 1;
        int nMax = n - 1;
        while (mMax >= 0 && nMax >= 0) {
            if (nums1[mMax] > nums2[nMax]) {
                nums1[end--] = nums1[mMax--];
            } else {
                nums1[end--] = nums2[nMax--];
            }
        }
        while (nMax >= 0) {
            nums1[end--] = nums2[nMax--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8, 9};

        System.out.println("原数组1：");
        printArray(nums1);  // 输出：1 3 5 7

        System.out.println("原数组2：");
        printArray(nums2);  // 输出：2 4 6 8 9

        int[] merged = merge2(nums1, nums2);
        System.out.println("合并后数组：");
        printArray(merged);  // 输出：1 2 3 4 5 6 7 8 9
    }


}
