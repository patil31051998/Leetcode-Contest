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
    public int maxAncestorDiff(TreeNode root) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        return maxAncestorDiff(root, minHeap, maxHeap);
    }

    private int maxAncestorDiff(TreeNode root, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if(root == null) {
            return 0;
        }
        minHeap.add(root.val);
        maxHeap.add(root.val);
        int left = maxAncestorDiff(root.left, minHeap, maxHeap);
        int right = maxAncestorDiff(root.right, minHeap, maxHeap);
        int curr = Math.max(Math.abs(root.val - minHeap.peek()), Math.abs(root.val - maxHeap.peek()));
        minHeap.remove(root.val);
        maxHeap.remove(root.val);
        return Math.max(curr, Math.max(left, right));
    }
}