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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        return pathSum(root, targetSum, prefixSumCount, 0L);
    }

    public int pathSum(TreeNode root, int targetSum, Map<Long, Integer> prefixSumCount, long sum) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        if(root.val + sum == (long)targetSum) {
            count++;
        }
        count += prefixSumCount.getOrDefault(root.val + sum - targetSum, 0);
        prefixSumCount.put(root.val + sum, prefixSumCount.getOrDefault(root.val + sum, 0) + 1);
        count += pathSum(root.left, targetSum, prefixSumCount, root.val + sum);
        count += pathSum(root.right, targetSum, prefixSumCount, root.val + sum);
        prefixSumCount.put(root.val + sum, prefixSumCount.get(root.val + sum) - 1);
        return count;
    }
}