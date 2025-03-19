class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low, high, mid, ans;
        long sum = 0L;
        ans = 1;
        Arrays.sort(candies);
        for(int curr : candies) {
            sum += curr;
        }
        if(sum < k) {
            return 0;
        }
        low = 1;
        high = candies[candies.length - 1];
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(isPossible(candies, k, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] candies, long k, int mid) {
        long curr = 0L;
        int i;
        for(i = 0; i < candies.length; i++) {
            curr += (candies[i] / mid);
            if(curr >= k) {
                return true;
            }
        }
        return false;
    }
}