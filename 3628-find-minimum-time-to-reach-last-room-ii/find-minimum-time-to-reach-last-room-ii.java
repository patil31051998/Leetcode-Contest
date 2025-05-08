class Node {
    int row;
    int col;
    int time;
    int cost;

    public Node(int row, int col, int time, int cost) {
        this.row = row;
        this.col = col;
        this.time = time;
        this.cost = cost;
    }
}

class Solution {

    private boolean isValid(int row, int col, int rowLen, int colLen) {
        return row >= 0 && row < rowLen && col >= 0 && col < colLen;
    }

    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.time - n2.time);
        int[][] visited = new int[moveTime.length][moveTime[0].length];
        pq.add(new Node(0, 0, 0, 1));
        int[] dR = {1, 0, -1, 0};
        int[] dC = {0, 1, 0, -1};
        visited[0][0] = 1;
        while(!pq.isEmpty()) {
            Node node = pq.remove();
            if(node.row == moveTime.length - 1 && node.col == moveTime[0].length - 1) {
                return node.time; 
            }
            for(int i = 0; i < 4; i++) {
                int row = node.row + dR[i];
                int col = node.col + dC[i];
                if(isValid(row, col, moveTime.length, moveTime[0].length) && visited[row][col] == 0) {
                    int time = Math.max(node.time, moveTime[row][col]) + node.cost;
                    int cost = node.cost == 1 ? 2 : 1;
                    visited[row][col] = 1;
                    pq.add(new Node(row, col, time, cost)); 
                }
            }
        }
        return -1;
    }
}