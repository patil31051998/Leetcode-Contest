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
        StringBuilder curr = new StringBuilder("");
        return sumNumbers(root, curr);
    }

    public int sumNumbers(TreeNode root, StringBuilder curr) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return Integer.valueOf(curr.toString() + root.val);
        }
        curr.append(root.val);
        int left = sumNumbers(root.left, curr);
        int right = sumNumbers(root.right, curr);
        curr.deleteCharAt(curr.length() - 1);
        return left + right;
    }
}