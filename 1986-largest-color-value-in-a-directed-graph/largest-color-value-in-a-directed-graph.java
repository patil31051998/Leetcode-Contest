class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adjList = getAdjList(edges, colors.length());
        int[] visited = new int[colors.length()];
        int[][] dp = new int[colors.length()][26];
        int i;
        int res = 0;
        for(i = 0; i < colors.length(); i++) {
            int currPath = largestPathValue(adjList, colors, i, visited, dp);
            if(currPath == -1) {
                return -1;
            }
            res = Math.max(res, currPath);
        }
        return res;
    }

    private int largestPathValue(List<List<Integer>> adjList, String colors, int curr, int[] visited, int[][] dp) {
        if(visited[curr] == 1) {
            return -1;
        }
        if(visited[curr] == 0) {
            visited[curr] = 1;
            for(int adj : adjList.get(curr)) {
                int currPath = largestPathValue(adjList, colors, adj, visited, dp);
                if(currPath == -1) {
                    return -1;
                }
                for(int i = 0; i < 26; i++) {
                    dp[curr][i] = Math.max(dp[curr][i], dp[adj][i]);
                }
            }
            visited[curr] = 2;
            dp[curr][colors.charAt(curr) - 'a']++;
        }
        return dp[curr][colors.charAt(curr) - 'a'];
    }

    private List<List<Integer>> getAdjList(int[][] edges, int len) {
        List<List<Integer>> adjList = new ArrayList<>();
        int i;
        for(i = 0; i < len; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
        return adjList;
    }
}