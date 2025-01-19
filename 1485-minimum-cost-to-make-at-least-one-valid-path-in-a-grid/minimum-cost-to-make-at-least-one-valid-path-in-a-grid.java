class Solution {

    private int MAX = (int)Math.pow(10, 9);

    public int minCost(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[grid.length][grid[0].length];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int i, j;
        for(int[] arr : cost) {
            Arrays.fill(arr, MAX);
        }
        deque.addFirst(new int[]{0, 0});
        cost[0][0] = 0;
        while(!deque.isEmpty()) {
            int[] ord =  deque.removeFirst();
            for(i = 0; i < 4; i++) {
                int x =  ord[0] + dx[i];
                int y =  ord[1] + dy[i];
                int nCost = grid[ord[0]][ord[1]] != i + 1 ? 1 : 0; 
                if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && cost[x][y] > nCost + cost[ord[0]][ord[1]]) {
                   cost[x][y] = nCost + cost[ord[0]][ord[1]];
                   if(nCost == 1) {
                        deque.addLast(new int[]{x, y}); 
                   }
                   else {
                        deque.addFirst(new int[]{x, y}); 
                   }
                }
            }
        }
        return cost[grid.length - 1][grid[0].length - 1];
    }
}