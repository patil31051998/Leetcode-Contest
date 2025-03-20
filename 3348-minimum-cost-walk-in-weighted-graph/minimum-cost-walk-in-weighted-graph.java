class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<List<int[]>> adjList = getAdjList(n, edges);
        Map<Integer, Integer> componentValMap = new HashMap<>();
        int[] component = new int[n];
        int[] res = new int[query.length];
        int i;
        int currComponent = 1;
        for(i = 0; i < n; i++) {
            if(component[i] == 0) {
                int[] val = {Integer.MAX_VALUE};
                dfs(i, adjList, currComponent, val, component);
                componentValMap.put(currComponent, val[0]);
                currComponent++;
            }
        }
        for(i = 0; i < query.length; i++) {
            if(component[query[i][0]] != component[query[i][1]]) {
                res[i] = -1;
            }
            else {
                res[i] = componentValMap.get(component[query[i][0]]);
            }
        }
        return res;
    }

    private void dfs(int i, List<List<int[]>> adjList, int currComponent, int[] val, int[] component) {
        component[i] = currComponent;
        for(int[] adj : adjList.get(i)) {
            val[0] = val[0] & adj[1];
            if(component[adj[0]] != 0) {
                continue;
            }
            dfs(adj[0], adjList, currComponent, val, component);
        }

    }

    private List<List<int[]>> getAdjList(int n, int[][] edges) {
        int i;
        List<List<int[]>> adjList = new ArrayList<>();
        for(i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        return adjList;
    } 
}