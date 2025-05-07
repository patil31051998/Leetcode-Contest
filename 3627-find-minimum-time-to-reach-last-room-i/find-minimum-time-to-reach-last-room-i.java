class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int[][] cost = new int[moveTime.length][moveTime[0].length];
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int i, j;
        for(i = 0; i < moveTime.length; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        int res = minTimeToReach(0, 0, moveTime, cost, dr, dc, 0);
        // for(i = 0; i < moveTime.length; i++) {
        //     System.out.println(Arrays.toString(cost[i]));
        // }
        return cost[moveTime.length - 1][moveTime[0].length - 1];
    }

    private int minTimeToReach(int r, int c, int[][] moveTime, int[][] cost,
            int[] dr, int[] dc, int currCost) {
        if(r == moveTime.length - 1 && c == moveTime[0].length - 1) {
            cost[r][c] = currCost;
            return 1;
        }
        cost[r][c] = currCost;
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if(newR >= 0 && newR < moveTime.length && newC >= 0 
                    && newC < moveTime[0].length) {
                    int newCost = Math.max(currCost + 1,  moveTime[newR][newC] + 1);
                    if(newCost < cost[newR][newC]) {
                        minCost = Math.min(minCost, minTimeToReach(newR, newC, moveTime, cost, dr, dc, newCost));
                    }
            }
        }
        return currCost + minCost;
    }
}