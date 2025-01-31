class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int len) {
        parent = new int[len];
        size = new int[len];
        for(int i = 0; i < len; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int getParent(int i) {
        if(i == parent[i]) {
            return i;
        }
        return parent[i] = getParent(parent[i]);
    }

    public int getSize(int i) {
        return size[i];
    }

    public void join(int v1, int v2) {
        int p1 = getParent(v1);
        int p2 = getParent(v2);
        if(p1 == p2) {
            return;
        }
        int s1 = getSize(p1);
        int s2 = getSize(p2);
        if(s1 >= s2) {
            parent[p2] = p1;
            size[p1] += size[p2];
        }
        else {
            parent[p1] = p2;
            size[p2] += size[p1];
        }
    }
}

class Solution {

    private boolean isValid(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    private int getNodeVal(int colLen, int r, int c) {
        return r * colLen + c;
    }

    public int largestIsland(int[][] grid) {
        int count, i, j, k;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        DisjointSet ds = new DisjointSet(grid.length * grid[0].length);
        count = 0;

        for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    for(k = 0; k < 4; k++) {
                        int r = i + dx[k];
                        int c = j + dy[k];
                        if(isValid(grid, r, c) && grid[r][c] == 1) {
                            ds.join(getNodeVal(grid[0].length, i, j), getNodeVal(grid[0].length, r, c));
                        }
                    }
                }
            }
        }

        for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[0].length; j++) {
                Set<Integer> components = new HashSet<>();
                if(grid[i][j] == 0) {
                    for(k = 0; k < 4; k++) {
                        int r = i + dx[k];
                        int c = j + dy[k];
                        if(isValid(grid, r, c) && grid[r][c] == 1) {
                            components.add(ds.getParent(getNodeVal(grid[0].length, r, c)));
                        }
                    }
                    int curr = 0;
                    for(int component : components) {
                        curr += ds.getSize(component);
                    }
                    count = Math.max(count, curr + 1);
                }
            }
        }

        return count == 0 ? grid.length * grid[0].length : count;
    }
}