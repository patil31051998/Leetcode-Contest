class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        int[] dfsVisited = new int[graph.length];
        int[] safe = new int[graph.length];
        int i;
        List<Integer> result = new ArrayList<>();
        for(i = 0; i < graph.length; i++) {
            if(visited[i] == 0) {
                dfs(i, graph, visited, dfsVisited, safe);
            }
        }
        for(i = 0; i < graph.length; i++) {
            if(safe[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int i, int[][] graph, int[] visited, int[] dfsVisited, int[] safe) {
        visited[i] = 1;
        dfsVisited[i] = 1;
        safe[i] = 0;
        for(int adj : graph[i]) {
            if(visited[adj] == 0) {
                if(dfs(adj, graph, visited, dfsVisited, safe)) {
                    return true;
                }     
            }
            if(dfsVisited[adj] == 1) {
                return true;
            }
        }
        dfsVisited[i] = 0;
        safe[i] = 1;
        return false;
    }
}