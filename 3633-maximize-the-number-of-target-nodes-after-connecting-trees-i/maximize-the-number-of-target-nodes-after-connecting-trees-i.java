class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1 = buildAdjList(edges1);
        List<List<Integer>> adj2 = buildAdjList(edges2);

        int maxReachableInTree2 = bfsMaxReachableNodes(adj2, k - 1);
        int n = edges1.length + 1;
        int[] result = new int[n];

        if (k == 0) {
            Arrays.fill(result, 1);
            return result;
        }

        for (int i = 0; i < n; i++) {
            int reachableFromNode = bfsNodeCount(adj1, i, k);
            result[i] = reachableFromNode + maxReachableInTree2;
        }

        return result;
    }

    private int bfsNodeCount(List<List<Integer>> adj, int start, int k) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int depth = 0, nodeCount = 0;

        while (!queue.isEmpty() && depth <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                nodeCount++;
                for (int neighbor : adj.get(node)) {
                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
            depth++;
        }

        return nodeCount;
    }

    private int bfsMaxReachableNodes(List<List<Integer>> adj, int k) {
        int maxNodes = 0;
        for (int i = 0; i < adj.size(); i++) {
            maxNodes = Math.max(maxNodes, bfsNodeCount(adj, i, k));
        }
        return maxNodes;
    }

    private List<List<Integer>> buildAdjList(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }
}
