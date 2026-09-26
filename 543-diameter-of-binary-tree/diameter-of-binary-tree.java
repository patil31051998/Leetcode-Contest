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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = {0}; 
        heightOfBinaryTree(root, diameter);
        return diameter[0];
    }

    public int heightOfBinaryTree(TreeNode root, int[] diameter) {
        if(root == null) {
            return 0;
        }
        int lH = heightOfBinaryTree(root.left, diameter);
        int rH = heightOfBinaryTree(root.right, diameter);
        diameter[0] = Math.max(diameter[0], lH + rH);
        return 1 + Math.max(lH, rH);
    }
}