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

    private Map<Integer, Integer> prepareInorderMap(int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        int i;
        for(i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return inorderMap;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = prepareInorderMap(inorder);
        int[] currIndex = {0};
        return buildTree(preorder, inorder, inorderMap, currIndex, 0, inorder.length - 1);
    }


    private TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int[] currIndex, int start, int end) {
        if(start > end) {
            return null;
        }
        int curr = preorder[currIndex[0]];
        int inorderIndex = inorderMap.get(curr);
        TreeNode node = new TreeNode(curr);
        currIndex[0]++;
        node.left = buildTree(preorder, inorder, inorderMap, currIndex, start, inorderIndex - 1);
        node.right = buildTree(preorder, inorder, inorderMap, currIndex, inorderIndex + 1, end);
        return node;
    }
}