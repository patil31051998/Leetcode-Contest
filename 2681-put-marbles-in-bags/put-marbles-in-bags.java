class Solution {
    public long putMarbles(int[] weights, int k) {
        int i;
        int[] sum = new int[weights.length];
        for(i = 0; i < weights.length - 1; i++) {
            sum[i] =  weights[i] + weights[i + 1];
        }
        Arrays.sort(sum);
        long max, min;
        max = min = 0;
        // System.out.println(Arrays.toString(sum));
        for(i = 0; i < k - 1; i++) {
            min += sum[i + 1];
            max += sum[weights.length - i - 1];
        }
        return max - min;
    }
}