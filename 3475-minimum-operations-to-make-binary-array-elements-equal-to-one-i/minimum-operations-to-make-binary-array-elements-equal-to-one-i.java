class Solution {
    public int minOperations(int[] nums) {
        int i, count;
        count = 0;
        for(i = 0; i < nums.length - 2; i++) {
            if(nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] = nums[i + 1] ^ 1;
                nums[i + 2] = nums[i + 2] ^ 1;
                count++;
            }
        }
        return nums[nums.length - 1] == 1 && nums[nums.length - 2] == 1 ? count : -1;
    }
}