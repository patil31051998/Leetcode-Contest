class Solution {
    public int maximumInvitations(int[] favorite) {
        int[] inDegree = new int[favorite.length];
        int[] depth = new int[favorite.length];
        int i;
        int twoLen = 0;
        int maxLen = 0;
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(depth, 1);
        for(i = 0; i < favorite.length; i++) {
            inDegree[favorite[i]]++;
        }
        for(i = 0; i < favorite.length; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            int next = favorite[curr];
            depth[next] = Math.max(depth[next], 1 + depth[curr]);
            inDegree[next]--;
            if(inDegree[next] == 0) {
                queue.add(next);
            }
        }
        for(i = 0; i < favorite.length; i++) {
            if(inDegree[i] == 0) {
                continue;
            }
            int len = 0;
            int curr = i;
            while(inDegree[curr] != 0) {
                len++;
                inDegree[curr] = 0;
                curr = favorite[curr];
            }
            if(len == 2) {
                twoLen += depth[i] + depth[favorite[i]];
            }
            else {
                maxLen = Math.max(maxLen, len);
            }
        }
        return Math.max(twoLen, maxLen);
    }
}