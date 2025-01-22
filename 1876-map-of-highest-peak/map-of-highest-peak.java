class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] res = new int[isWater.length][isWater[0].length];
        int i, j;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        for(i = 0; i < isWater.length; i++) {
            for(j = 0; j < isWater[0].length; j++) {
                if(isWater[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                int[] ord = queue.remove();
                for(i = 0; i < 4; i++) {
                    int newX = ord[0] + dx[i];
                    int newY = ord[1] + dy[i];
                    if(newX >= 0 && newX < isWater.length && newY >= 0 && newY < isWater[0].length && isWater[newX][newY] != 1 && res[newX][newY] == 0) {
                        res[newX][newY] = count;
                        queue.add(new int[] {newX, newY});
                    }
                }
                size--;
            }
            count++;
        }
        return res;
    }
}