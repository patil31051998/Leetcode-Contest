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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSum(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> result) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            if(targetSum == root.val) {
                curr.add(root.val);
                result.add(new ArrayList<>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }
        curr.add(root.val);
        pathSum(root.left, targetSum - root.val, curr, result);
        pathSum(root.right, targetSum - root.val, curr, result);
        curr.remove(curr.size() - 1);
    }
}