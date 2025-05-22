class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        PriorityQueue<Integer> usedQuery = new PriorityQueue<>();
        PriorityQueue<Integer> availableQuery = new PriorityQueue<>(Collections.reverseOrder());
        int queryIndex = 0;
        int usedQueryCount = 0;
        int i;
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        for(i = 0; i < nums.length; i++) {
            while(queryIndex < queries.length && queries[queryIndex][0] <= i) {
                availableQuery.add(queries[queryIndex][1]);
                queryIndex++;
            }
            int remaining = nums[i] - usedQuery.size();
            while(remaining > 0) {
                if(availableQuery.isEmpty() || availableQuery.peek() < i) {
                    return -1;
                }
                int curr = availableQuery.remove();
                remaining--;
                usedQueryCount++;
                usedQuery.add(curr);
            }
            while(!usedQuery.isEmpty() && usedQuery.peek() <= i) {
                usedQuery.remove();
            }
        }
        return queries.length - usedQueryCount;
    }
}