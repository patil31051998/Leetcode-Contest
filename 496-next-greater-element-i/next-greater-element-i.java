class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterElementMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        int i;
        for(i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                nextGreaterElementMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(i = 0; i < nums1.length; i++) {
            res[i] = nextGreaterElementMap.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}