class Solution {
    public int countServers(int[][] grid) {
        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        int i, j, count;
        count = 0;
        for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
         for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[0].length; j++) {
                if((grid[i][j] == 1) && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
         }
        return count;
    }
}