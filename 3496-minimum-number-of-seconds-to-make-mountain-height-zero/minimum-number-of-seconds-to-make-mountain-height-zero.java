class Node {
    private int heightCount;
    private int workerTime;
    
    public Node(int heightCount, int workerTime) {
        this.heightCount = heightCount;
        this.workerTime = workerTime;
    }
    
    public int getHeightCount() {
        return heightCount;
    }
    
    public int getWorkerTime() {
        return workerTime;
    }
}

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            long v1 = ((a.getHeightCount() * (a.getHeightCount() + 1L)) / 2) * a.getWorkerTime();
            long v2 = ((b.getHeightCount() * (b.getHeightCount() + 1L)) / 2) * b.getWorkerTime();
            return (int)(v1 - v2);
        });
        long res = 0L;
        for(int time : workerTimes) {
            pq.add(new Node(1, time));
        }
        while(mountainHeight > 0) {
            Node node = pq.remove();
            long count = ((node.getHeightCount() * (node.getHeightCount() + 1L)) / 2) * node.getWorkerTime();
            res = Math.max(res, count);
            pq.add(new Node(node.getHeightCount() + 1, node.getWorkerTime()));
            mountainHeight--;
        }
        return res;
        // long[] workerTimeElapsed = new long[workerTimes.length];
        // int i = 0;
        // long res = 0L;
        // Arrays.sort(workerTimes);
        // while(mountainHeight > 0) {
        //     workerTimeElapsed[i % workerTimes.length] += ((i / workerTimes.length) + 1) * workerTimes[i % workerTimes.length];
        //     mountainHeight--;
        //     i++;
        //     System.out.println(Arrays.toString(workerTimeElapsed));
        // }
        // for(long time : workerTimeElapsed) {
        //     res = Math.max(time, res);
        // }
        // return res;
    }
}