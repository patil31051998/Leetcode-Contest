class Solution {
    public int findMaxFish(int[][] grid) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int i, j, max;
        max = 0;
        for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > 0) {
                    int[][] visited = new int[grid.length][grid[0].length];
                    max = Math.max(max, findMaxFish(grid, i, j, dx, dy, visited));
                }
            }
        }
        return max;
    }

    private int findMaxFish(int[][] grid, int i, int j, int[] dx, int[] dy, int[][] visited) {
        if(visited[i][j] == 1) {
            return 0;
        }
        visited[i][j] = 1;
        int curr = grid[i][j];
        int k;
        for(k = 0; k < 4; k++) {
            int r = i + dx[k];
            int c = j + dy[k];
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] > 0) {
                curr += findMaxFish(grid, r, c, dx, dy, visited);
            }
        }
        return curr;
    }
}