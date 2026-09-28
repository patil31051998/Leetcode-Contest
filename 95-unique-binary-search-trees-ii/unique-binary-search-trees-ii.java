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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if(left > right) {
            result.add(null);
        } else if(left == right) {
            result.add(new TreeNode(left));
        } else {
            for(int i = left; i <= right; i++) {
                List<TreeNode> leftTrees = generateTrees(left, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, right);
                for(int j = 0; j < leftTrees.size(); j++) {
                    for(int k = 0; k < rightTrees.size(); k++) {
                        TreeNode currTree = new TreeNode(i);
                        currTree.left = leftTrees.get(j);
                        currTree.right = rightTrees.get(k);
                        result.add(currTree);
                    }
                }
            }
        }
        return result;
    }
}