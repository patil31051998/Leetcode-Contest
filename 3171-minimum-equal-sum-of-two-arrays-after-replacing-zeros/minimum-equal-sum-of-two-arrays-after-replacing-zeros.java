class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1, sum2;
        int zero1, zero2;
        int i;
        sum1 = sum2 = 0L;
        zero1 = zero2 = 0;
        for(i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            if(nums1[i] == 0) {
                zero1++;
            }
        }
        for(i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
            if(nums2[i] == 0) {
                zero2++;
            }
        }
        // System.out.println(sum1 + ":" + sum2);
        sum1 += (1 * (zero1 == 0 ? 0 : zero1 - 1));
        sum2 += (1 * (zero2 == 0 ? 0 : zero2 - 1));
        // System.out.println(sum1 + "::" + sum2);
        if(zero1 == 0 && zero2 == 0) {
            return sum1 == sum2 ? sum1 : -1;
        }
        else if(zero1 != 0 && zero2 != 0) {
            return sum1 > sum2 ? sum1 + 1 : sum2 + 1;
        }
        else {
            if(zero1 == 0) {
                return sum1 <= sum2 ? -1 : sum1;
            } else {
                return sum1 >= sum2 ? -1 : sum2;
            }
        }
    }
}