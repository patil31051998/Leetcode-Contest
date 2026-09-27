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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        height--;
        List<List<String>> resultMatrix = constructEmptyMatrix(height);
        printTree(root, resultMatrix, 0, (resultMatrix.get(0).size() - 1) / 2, height);
        return resultMatrix;
    }

    private void printTree(TreeNode root, List<List<String>> resultMatrix, int row, int col, int height) {
        if(root == null) {
            return;
        }
        resultMatrix.get(row).set(col, root.val + "");
        int leftCol = col - (int)Math.pow(2, height - row - 1);
        int rightCol = col + (int)Math.pow(2, height - row - 1);
        printTree(root.left, resultMatrix, row + 1, leftCol, height);
        printTree(root.right, resultMatrix, row + 1, rightCol, height);
    }

    private List<List<String>> constructEmptyMatrix(int height) {
        List<List<String>> resultMatrix = new ArrayList<>();
        for(int i = 0; i <= height; i++) {
            List<String> curr = new ArrayList<>();
            for(int j = 0; j < (int)Math.pow(2, height + 1) - 1; j++) {
                curr.add("");
            }
            resultMatrix.add(curr);
        }
        return resultMatrix;
    }

    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    } 
}