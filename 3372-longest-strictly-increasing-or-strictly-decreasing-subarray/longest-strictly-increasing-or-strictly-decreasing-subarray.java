class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int seqType, i, count, max;
        seqType = 0;
        count = 1;
        max = 1;
        for(i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                count = 1;
                seqType = 0;
            }
            else {
                if(seqType == 0) {
                    count = 2;
                    if(nums[i] > nums[i - 1]) {
                        seqType = 1;
                    }
                    else {
                        seqType = -1;
                    }
                }
                else if(seqType == 1) {
                    if(nums[i] > nums[i - 1]) {
                        count++;
                    }
                    else {
                        count = 2;
                        seqType = -1;
                    }

                }
                else {
                    if(nums[i] > nums[i - 1]) {
                        count = 2;
                        seqType = 1;
                    }
                    else {
                        count++;
                    }

                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}