class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1 = getAdjList(edges1);
        List<List<Integer>> adj2 = getAdjList(edges2);
        int tree2MaxTraget = getMaxTargetNode(adj2, k - 1);
        System.out.println(tree2MaxTraget);
        int[] res = new int[edges1.length + 1];
        if(k == 0) {
            Arrays.fill(res, 1);
            return res;
        }
        int i;
        for(i = 0; i <= edges1.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int count = 0;
            int currNodeCount = 0;
            queue.add(i);
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            while(count <= k) {
                int size = queue.size();
                while(size > 0) {
                    int val = queue.remove();
                    currNodeCount++;
                    for(int adj : adj1.get(val)) {
                        if(!visited.contains(adj)) {
                            visited.add(adj);
                            queue.add(adj);
                        }
                    }
                    size--;
                }
                count++;
            }
            res[i] = currNodeCount + tree2MaxTraget;
        }
        return res;
    }

    private int getMaxTargetNode(List<List<Integer>> adj, int k) {
        if(k == 0) {
            return 1;
        }
        int maxNodeCount = 0;
        int i;
        for(i = 0; i < adj.size(); i++) {
            Queue<Integer> queue = new LinkedList<>();
            int count = 0;
            int currNodeCount = 0;
            queue.add(i);
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            while(count <= k) {
                int size = queue.size();
                while(size > 0) {
                    int val = queue.remove();
                    currNodeCount++;
                    for(int nei : adj.get(val)) {
                        if(!visited.contains(nei)) {
                            visited.add(nei);
                            queue.add(nei);
                        }
                    }
                    size--;
                }
                count++;
            }
            maxNodeCount = Math.max(maxNodeCount, currNodeCount);
        }
        return maxNodeCount;
    }
    
    
    private List<List<Integer>> getAdjList(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int i;
        for(i = 0; i <= edges.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }
}