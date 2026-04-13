class Solution {
    public int minOperations(int[] nums) {
        int operationCount = 0;
        for(int i = 0; i < nums.length; i++) {
            operationCount += minOperations(nums[i], i % 2 == 0);
        }
        return operationCount;
    }

    private int minOperations(int num, boolean isPrime) {
        int operationCount = 0;
        boolean curr = isPrime(num);
        while(curr != isPrime) {
            num++;
            curr = isPrime(num);
            operationCount++;
        }
        return operationCount;
    }

    private boolean isPrime(int num) {
        if(num == 1) {
            return false;
        }
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}