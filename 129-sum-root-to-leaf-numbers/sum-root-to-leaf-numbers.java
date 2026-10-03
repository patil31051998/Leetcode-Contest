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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int curr) {
        if(root == null) {
            return 0;
        }
        int sum = curr * 10 + root.val;
        if(root.left == null && root.right == null) {
            return sum;
        }
        int left = sumNumbers(root.left, sum);
        int right = sumNumbers(root.right, sum);
        return left + right;
    }
}