class Solution {
    public int sortableIntegers(int[] nums) {
        int i;
        int res = 0;
        for(i = 1; i <= nums.length; i++) {
            if(nums.length % i != 0) {
                continue;
            }
            int batchCount = nums.length / i;
            int currMin, currMax, prevMax;
            prevMax = Integer.MIN_VALUE;
            int j;
            for(j = 0; j < nums.length; j = j + i) {
                currMin = Integer.MAX_VALUE;
                currMax = Integer.MIN_VALUE;
                int count = 0;
                for(int k = 0; k < i; k++) {
                    int curr = nums[j + k];
                    int next = nums[j + (k + 1) % i];
                    // if(i == 3) {
                    //     System.out.println(curr + "->" + next);
                    // }
                    if(curr > next) {
                        count++;
                    } 
                    if(count == 2) {
                        break;
                    }
                    currMin = Math.min(currMin, curr);
                    currMax = Math.max(currMax, curr);
                }
                // if(i == 3) {
                //     System.out.println(j + ":" + currMin + ":" + currMax + ":" + prevMax);
                // }
                if(count == 2) {
                    break;
                }
                if(prevMax != Integer.MIN_VALUE && currMin < prevMax) {
                    break;
                }
                prevMax = currMax;
            }
            if(j == nums.length) {
                res += i;
            }
        }
        return res;
    }
}