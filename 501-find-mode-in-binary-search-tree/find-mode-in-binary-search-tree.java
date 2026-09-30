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

    int currStreak = 0;
    int maxStreak = 0;
    int currNum = 0;
    List<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] maxElement = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            maxElement[i] = res.get(i);
        }
        return maxElement;
    }

    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        if(root.val == currNum) {
            currStreak++;
        } else {
            currNum = root.val;
            currStreak = 1;
        }
        if(currStreak > maxStreak) {
            maxStreak = currStreak;
            res = new ArrayList<>();
        }
        if(currStreak == maxStreak) {
            res.add(currNum);
        }
        dfs(root.right);
    }
}