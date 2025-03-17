class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low, high, ans, mid;
        low = ans = 1L;
        high = (long)Math.pow(10, 14);
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(isPermissble(ranks, cars, mid)) {
                high = mid - 1;
                ans = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPermissble(int[] ranks, int cars, long mid) {
        int count = 0;
        for(int rank : ranks) {
            count += (int)Math.sqrt(mid / rank);
            if(count >= cars) {
                return true;
            }
        }
        return count >= cars;
    }


    
}