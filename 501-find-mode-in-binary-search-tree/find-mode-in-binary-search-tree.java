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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> countMap = new TreeMap<>();
        int[] maxCount = {0};
        getCount(root, countMap, maxCount);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == maxCount[0]) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void getCount(TreeNode root, Map<Integer, Integer> countMap, int[] maxCount) {
        if(root == null) {
            return;
        }
        countMap.put(root.val, countMap.getOrDefault(root.val, 0) + 1);
        maxCount[0] = Math.max(maxCount[0], countMap.get(root.val));
        getCount(root.left, countMap, maxCount);
        getCount(root.right, countMap, maxCount);
    }
}