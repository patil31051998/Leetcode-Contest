class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i, j, max, curr, prev;
        max = 1;
        for(i = 0; i < nums.length; i++) {
            curr = nums[i];
            if(max > nums.length - (i + 1)) {
                    break;
            }
            for(j = i + 1; j < nums.length; j++) {
                prev = curr;
                curr = curr ^ nums[j];
                // System.out.println(i + ":" + j + ":" + prev + ":" + curr + ":" + isMissing(prev, curr));
                if(isMissing(prev, curr)) {
                    break;
                }
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

    private boolean isMissing(int prev, int curr) {
        int i;
        // System.out.println("For " + prev + "::" + curr);
        for(i = 0; i < 32; i++) {
            int v1 = (prev >> i) & 1;
            int v2 = (curr >> i) & 1;
            // System.out.println(v1 + "::" + v2);
            if(v1 == 1 && v2 == 0) {
                return true;
            }
        }
        return false;
    }
}