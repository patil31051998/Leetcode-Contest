class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length];
        int curr, i;
        curr = 0;
        for(int[] query : queries) {
            diff[query[0]]--;
            if(query[1] < nums.length - 1) {
                diff[query[1] + 1]++;
            }
        }
        // System.out.println(Arrays.toString(diff));
        for(i = 0; i < nums.length; i++) {
            curr += diff[i];
            // System.out.println(curr + ":" + (nums[i] - curr));
            if(nums[i] + curr > 0) {
                return false;
            }
        }
        return true;
    }
}