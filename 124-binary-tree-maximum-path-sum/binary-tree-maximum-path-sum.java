/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = {-1001};
        maxPathSum(root, maxSum);
        return maxSum[0];
    }

    public int maxPathSum(TreeNode root, int[] maxSum) {
        if(root == null) {
            return 0;
        }
        int leftSum = maxPathSum(root.left, maxSum);
        int rightSum = maxPathSum(root.right, maxSum);
        int currMaxSum = Math.max(leftSum, rightSum);
        maxSum[0] = Math.max(maxSum[0], root.val + (leftSum > 0 ? leftSum : 0)
                      + (rightSum > 0 ? rightSum : 0));
        if(root.val + currMaxSum > 0) {
            return root.val + currMaxSum;
        } else {
            return 0;
        }
    }
}