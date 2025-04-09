class Solution {
    public int minOperations(int[] nums, int k) {
        int i;
        Set<Integer> elementsGreaterThanK = new HashSet<>();
        for(i = 0; i < nums.length; i++) {
            if(nums[i] < k) {
                return -1;
            }
            else if(nums[i] > k) {
                elementsGreaterThanK.add(nums[i]);
            }
        }
        return elementsGreaterThanK.size();
    }
}