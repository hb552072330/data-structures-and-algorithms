package top100;

public class Top51MaxPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Info ans = process(root);
        return ans.maxSum;
    }

    private Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int maxSum = x.val;
        int maxHeadSum = x.val;
        if (leftInfo != null) {
            maxSum = Math.max(maxSum, leftInfo.maxSum);
            maxHeadSum = Math.max(maxHeadSum, leftInfo.maxHeadSum + x.val);
        }
        if (rightInfo != null) {

            maxHeadSum = Math.max(maxHeadSum, rightInfo.maxHeadSum + x.val);

            maxSum = Math.max(maxSum, rightInfo.maxSum);
        }
        maxSum = Math.max(maxSum, maxHeadSum);
        if (leftInfo != null & rightInfo != null && rightInfo.maxHeadSum > 0 && leftInfo.maxHeadSum > 0) {
            maxSum = Math.max(maxSum, rightInfo.maxHeadSum + leftInfo.maxHeadSum + x.val);
        }
        return new Info(maxSum, maxHeadSum);
    }

    public static class Info {
        public int maxSum;
        public int maxHeadSum;

        public Info(int maxSum, int maxHeadSum) {
            this.maxSum = maxSum;
            this.maxHeadSum = maxHeadSum;
        }
    }


}
