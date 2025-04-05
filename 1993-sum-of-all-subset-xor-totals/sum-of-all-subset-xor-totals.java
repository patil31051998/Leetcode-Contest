class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXORSum(nums, 0, 0);
    }

    private int subsetXORSum(int[] nums, int i, int xor) {
        if(i == nums.length) {
            return xor;
        }
        int pick = subsetXORSum(nums, i + 1, nums[i] ^ xor);
        int notPick = subsetXORSum(nums, i + 1, xor);
        return pick + notPick;
    }
}