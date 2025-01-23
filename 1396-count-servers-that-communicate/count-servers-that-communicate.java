class Solution {
    public int countServers(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int i, j, count;
        count = 0;
        for(i = 0; i < visited.length; i++) {
            for(j = 0; j < visited[0].length; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    int val = dfs(grid, i, j, visited);
                    count += (val > 0 ? val + 1 : val);
                }
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int i, int j, int[][] visited) {
        visited[i][j] = 1;
        int x, count;
        count = 0;
        for(x = 0; x < grid.length; x++) {
            if(grid[x][j] == 1 && visited[x][j] == 0) {
                count++;
                count += dfs(grid, x, j, visited);
            }
        }
        for(x = 0; x < grid[0].length; x++) {
            if(grid[i][x] == 1 && visited[i][x] == 0) {
                count++;
                count += dfs(grid, i, x, visited);
            }
        }
        return count;
    }
}