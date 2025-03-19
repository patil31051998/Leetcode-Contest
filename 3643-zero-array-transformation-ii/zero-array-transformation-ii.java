class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int zeroCount, i, count;
        zeroCount = count = 0;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
            }
        }
        for(i = 0; i < queries.length; i++) {
            if(zeroCount == nums.length) {
                return count;
            }
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            while(l <= r) {
                if(nums[l] != 0) {
                    nums[l] = Math.max(0, nums[l] - val);
                    if(nums[l] == 0) {
                        zeroCount++;
                    }
                }
                l++;
            }
            count++;
        }
        return zeroCount == nums.length ? count : -1;
    }
}