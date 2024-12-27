class Solution {
    public int minimumOperations(int[] nums) {
        int i, j;
        int[] count = new int[101];
        int res = 0;
        for(i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for(i = 0; i < nums.length; i = i + 3) {
            if(isUnique(count)) {
                return res;
            }
            for(j = i; j < i + 3 && j < nums.length; j++) {
                count[nums[j]]--;
            }
            res++;
        }
        
        return res;        
    }
    
    private boolean isUnique(int[] count) {
        int i;
        for(i = 0; i < count.length; i++) {
            if(count[i] > 1) {
                return false;
            }
        }
        return true;
    }
}