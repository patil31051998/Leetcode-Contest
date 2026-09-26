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
    public int kthSmallest(TreeNode root, int k) {
        int[] curr = {k};
        int[] res = {0};
        kthSmallest (root, curr, res);
        return res[0];
    }

    public void kthSmallest(TreeNode root, int[] curr, int[] res) {
        if(root == null) {
            return;
        }
        kthSmallest (root.left, curr, res);
        curr[0]--;
        if(curr[0] == 0) {
            res[0] = root.val;
        }
        kthSmallest (root.right, curr, res);
    }
}