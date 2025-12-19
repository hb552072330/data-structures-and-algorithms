package other;

/**
 * @Author zhanghongbing
 * @Date 2025-11-18 14:46
 **/
public class Code01 {

    //示例 1：
    //
    //输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
    //输出：[2,2,2,1,4,3,3,9,6,7,19]
    //示例  2:
    //
    //输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
    //输出：[22,28,8,6,17,44]
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int num : arr2) {
           while (count[num]-- > 0){
               ans[index++] = num;
           }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0){
                ans[index++] = i;
            }
        }
        return ans;
    }

}
