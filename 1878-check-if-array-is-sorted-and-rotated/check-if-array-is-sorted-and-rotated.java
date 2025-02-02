class Solution {
    public boolean check(int[] nums) {
        int i;
        int inversionCount = 0;
        if(nums.length <= 2) {
            return true;
        }
        for(i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]) {
                inversionCount++;
            }
        }
        if(nums[0] < nums[nums.length - 1]) {
            inversionCount++;
        }

        return inversionCount <= 1;
    }
}