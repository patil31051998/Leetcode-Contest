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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lH = getLeftHeight(root.left);
        int rH = getRightHeight(root.right);
        if(lH == rH) {
            return (int)Math.pow(2, lH + 1) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int getLeftHeight(TreeNode root) {
        int height = 0;
        TreeNode curr = root;
        while(curr != null) {
            curr = curr.left;
            height++;
        }
        return height;
    }

    private int getRightHeight(TreeNode root) {
        int height = 0;
        TreeNode curr = root;
        while(curr != null) {
            curr = curr.right;
            height++;
        }
        return height;
    }
}