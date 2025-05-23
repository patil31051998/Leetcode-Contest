class Solution {
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        List<List<Integer>> adjList = getAdjList(edges, values.length);
        long sum = 0L;
        Set<Integer> visited = new HashSet<>();
        for(int value : values) {
            sum += value;
        }
        return sum - getMinimumScoreAfterOperation(adjList, 0, values, visited);
    }

    private long getMinimumScoreAfterOperation(List<List<Integer>> adjList,
            int curr, int[] values, Set<Integer> visited) {
        long currSum =  0;
        visited.add(curr);
        for(int adj : adjList.get(curr)) {
            if(!visited.contains(adj)) {
                currSum += getMinimumScoreAfterOperation(adjList, adj, values, visited);
            }
        }
        return currSum == 0L? values[curr] : Math.min(currSum, values[curr]); 
    }

    private List<List<Integer>> getAdjList(int[][] edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();
        int i;
        for(i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }
}