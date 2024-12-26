class Solution {
    public int getMaximumGold(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int i, j, max;
        max = 0;
        for (i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[0].length; j++) {
                int[][] visited = new int[grid.length][grid[0].length];
                max = Math.max(max, getMaximumGold(grid, i, j, dx, dy, visited));
                // System.out.println(max + ":::");
            }
        }
        return max;
    }

    private int getMaximumGold(int[][] grid, int row, int col, int[] dx, int[] dy, int[][] visited) {
        // System.out.println(row + "::" + col);
        if(grid[row][col] == 0) {
            return 0;
        }
        visited[row][col] = 1;
        int i, max;
        max = grid[row][col];
        for(i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && visited[x][y] == 0) {
                max = Math.max(max, grid[row][col] + getMaximumGold(grid, x, y, dx, dy, visited));
            }
        }
        visited[row][col] = 0;
        return max;
    }
}