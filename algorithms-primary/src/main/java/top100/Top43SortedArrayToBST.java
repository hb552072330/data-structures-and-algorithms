package top100;

public class Top43SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int L, int R) {
        if (L > R) {
            return null;
        }
        int mid = (L + R) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, L, mid - 1);
        node.right = buildBST(nums, mid - 1, R);
        return node;
    }


}
