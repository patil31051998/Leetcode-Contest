

class Solution {

    class Data {
    private int node;
    private long dist;

    public Data(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }

    public int getNode() {
        return node;
    }

    public long getdist() {
        return this.dist;
    } 

}

    private final int MOD = (int)(Math.pow(10, 9) + 7);

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adjList = getAdjList(n, roads);
        long[] distance = new long[n];
        int[] ways = new int[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;
        PriorityQueue<Data> queue = new PriorityQueue<>((d1, d2) -> {
            return (int)(d1.getdist() - d2.getdist());
        });
        queue.add(new Data(0, 0));
        while(!queue.isEmpty()) {
            Data curr = queue.remove();
            for(int[] adj : adjList.get(curr.getNode())) {
                if(distance[adj[0]] == curr.getdist() + adj[1]) {
                    ways[adj[0]] = (ways[adj[0]] + ways[curr.getNode()]) % MOD;
                }
                if(distance[adj[0]] > curr.getdist() + adj[1]) {
                    ways[adj[0]] = ways[curr.getNode()];
                    distance[adj[0]] = curr.getdist() + adj[1];
                    queue.add(new Data(adj[0], distance[adj[0]]));
                }
            }
        }
        return ways[n - 1];
    }

    private List<List<int[]>> getAdjList(int n, int[][] roads) {
        List<List<int[]>> adjList = new ArrayList<>();
        int i;
        for(i = 0; i < n; i++) {
            adjList.add(new ArrayList());
        }
        for(int[] road : roads) {
            adjList.get(road[0]).add(new int[] { road[1], road[2]});
            adjList.get(road[1]).add(new int[] { road[0], road[2]});
        }
        return adjList;
    }
}