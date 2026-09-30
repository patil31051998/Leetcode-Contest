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

    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        int left = kthSmallest(root.left, k);
        if(left != -1) {
            return left;
        }
        count++;
        if(k == count) {
            return root.val;
        }
        return kthSmallest(root.right, k);
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