class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int num : nums) {
            while(num > 0) {
                int curr = num % 10;
                if(curr == digit) {
                    count++;
                }
                num = num / 10;
            }
        }
        return count;
    }
}