class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adjList = getAdjList(n, edges);
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        int i, j;
        int res = 0;
        List<Integer> components = new ArrayList<>();
        for(i = 1; i <= n; i++) {
            if(color[i] == -1) {
                components.clear();
                int curr = 0;
                if(!isBipartite(i, adjList, color, components)) {
                    return -1;
                }
                // System.out.println(components);
                for(j = 0; j < components.size(); j++) {
                    int[] visited = new int[n + 1];
                    curr = Math.max(curr, bfs(adjList, components.get(j), visited));
                }
                res += curr;
            }
        }
        return res;
    }

    private int bfs(List<List<Integer>> adjList, int i, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.add(i);
        visited[i] = 1;
        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while(size > 0) {
                int curr = queue.remove();
                for(int adj : adjList.get(curr)) {
                    if(visited[adj] == 0) {
                        queue.add(adj);
                        visited[adj] = 1;
                    }
                }
                size--;
            }
        }
        return count;
    }

    private boolean isBipartite(int i, List<List<Integer>> adjList, int[] color, List<Integer> components) {
        components.add(i);
        if(color[i] == -1) {
            color[i] = 0;
        }
        for(int adj : adjList.get(i)) {
            if(color[adj] == -1) {
                color[adj] = 1 - color[i];
                if(!isBipartite(adj, adjList, color, components)) {
                    return false;
                }
            }
            else if(color[adj] == color[i]) {
                return false;
            }
        }
        return true;
    }

    private List<List<Integer>> getAdjList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        int i;
        for(i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    } 
}