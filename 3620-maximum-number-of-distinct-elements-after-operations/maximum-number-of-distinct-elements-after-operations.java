class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = nums.length;
        int i, prev;
        prev = Integer.MIN_VALUE;
        for(i = 0; i < nums.length; i++) {
            // System.out.println(count);
            if(prev >= nums[i] + k) {
                count--;
            }
            else {
                prev = Math.max(prev + 1, nums[i] - k);
            }
        }
        return count;
    }
}