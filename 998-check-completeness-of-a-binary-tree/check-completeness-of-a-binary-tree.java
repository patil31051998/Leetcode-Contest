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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isNullFound = false;
        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if(curr.left == null) {
                isNullFound = true;
            } else {
                if(isNullFound) {
                    return false;
                } else {
                    queue.add(curr.left);
                }
            }
            if(curr.right == null) {
                isNullFound = true;
            } else {
                if(isNullFound) {
                    return false;
                } else {
                    queue.add(curr.right);
                }
            }
        }
        return true;
    }
}