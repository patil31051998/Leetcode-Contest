class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] data = new int[grid.length * grid[0].length];
        int i, j, mid, res;
        res = 0;
        for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[i].length; j++) {
                data[i * grid[0].length + j] = grid[i][j];
            }
        }
        Arrays.sort(data);
        if(data.length % 2 == 1) {
            mid = data.length / 2;
        }
        else {
            mid = (data.length - 1) / 2;
        }
        for(i = 0; i < data.length; i++) {
            if(Math.abs(data[i] - data[mid]) % x != 0) {
                return -1;
            }
            else {
                res += (Math.abs(data[i] - data[mid]) / x);
            }
        }
        return res;
    }
}