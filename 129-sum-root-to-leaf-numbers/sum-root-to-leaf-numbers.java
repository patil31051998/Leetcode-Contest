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
        return sumNumbers(root, "");
    }

    public int sumNumbers(TreeNode root, String curr) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return Integer.valueOf(curr + root.val);
        }
        int left = sumNumbers(root.left, curr + root.val);
        int right = sumNumbers(root.right, curr + root.val);
        return left + right;
    }
}