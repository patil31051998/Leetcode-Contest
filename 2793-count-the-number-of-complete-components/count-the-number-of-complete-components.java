class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = getAdjList(n, edges);
        int i, j;
        int res = 0;
        int[] visited = new int[n];
        for(i = 0; i < n; i++) {
            if(visited[i] == 0) {
                List<Integer> components = new ArrayList<>();
                dfs(adjList, visited, components, i, -1);
                for(j = 0; j < components.size(); j++) {
                    if(adjList.get(components.get(j)).size() != components.size() - 1) {
                        break;
                    }
                }
                if(j == components.size()) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> adjList, int[] visited, List<Integer> components, int curr, int par) {
        visited[curr] = 1;
        components.add(curr);
        for(int adj : adjList.get(curr)) {
            if(visited[adj] == 0) {
                dfs(adjList, visited, components, adj, curr);
            }
        }
    }

    private List<List<Integer>> getAdjList(int n, int[][] edges) {
        int i;
        List<List<Integer>> adjList = new ArrayList<>();
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