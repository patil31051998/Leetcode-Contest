class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left, right, sum, maxSum, i;
        sum = 0;
        left = k - 1;
        right = cardPoints.length - 1;
        for(i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        maxSum = sum;
        while(left >= 0) {
            sum = sum - cardPoints[left] + cardPoints[right];
            left--;
            right--;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}