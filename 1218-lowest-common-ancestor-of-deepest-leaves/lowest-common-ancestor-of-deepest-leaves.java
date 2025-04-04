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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = getMaxDepth(root);
        return dfs(root, 0, maxDepth);
    }

    private int getMaxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

    private TreeNode dfs(TreeNode root, int currDepth, int maxDepth) {
        if(root == null) {
            return null;
        }
        if(currDepth == maxDepth - 1) {
            return root;
        }
        TreeNode left = dfs(root.left, currDepth + 1, maxDepth);
        TreeNode right = dfs(root.right, currDepth + 1, maxDepth);
        if(left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}