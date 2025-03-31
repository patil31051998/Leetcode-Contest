class Solution {
    public long putMarbles(int[] weights, int k) {
        int i;
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        long maxSum, minSum;
        maxSum = minSum = 0L;
        for(i = 0; i < weights.length - 1; i++) {
            maxPq.add(weights[i] + weights[i + 1]);
            if(maxPq.size() > k - 1) {
                maxPq.remove();
            }
            minPq.add(weights[i] + weights[i + 1]);
            if(minPq.size() > k - 1) {
                minPq.remove();
            }
        }
        while(!maxPq.isEmpty()) {
            minSum += maxPq.remove();
            maxSum += minPq.remove();
        }
        return maxSum - minSum;
    }
}