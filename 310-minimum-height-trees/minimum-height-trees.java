class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) {
            return List.of(0);
        }
        List<Set<Integer>> adjList = getAdjList(n, edges);
        List<Integer> leaves = new ArrayList<>();
        int i;
        for(i = 0; i < adjList.size(); i++) {
            if(adjList.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        int remainingNodes = n;
        while(remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves) {
                int neightbor = adjList.get(leaf).iterator().next();
                adjList.get(neightbor).remove(leaf);
                if(adjList.get(neightbor).size() == 1) {
                    newLeaves.add(neightbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    private List<Set<Integer>> getAdjList(int n, int[][] edges) {
        List<Set<Integer>> adjList = new ArrayList<>();
        int i;
        for(i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }
}