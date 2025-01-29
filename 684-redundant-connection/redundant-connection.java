class DisjointSet {
    int[] rank;
    int[] parent;

    public DisjointSet(int size) {
        rank = new int[size];
        parent = new int[size];
        for(int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int getParent(int i) {
        if(i == parent[i]) {
            return i;
        }
        return parent[i] = getParent(parent[i]);
    }

    public void join(int v1, int v2) {
        int p1 = getParent(v1);
        int p2 = getParent(v2);
        if(p1 == p2) {
            return;
        }
        if(rank[p1] < rank[p2]) {
            parent[p1] = p2;
        }
        else if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
        }
        else {
            parent[p1] = p2;
            rank[p2]++;
        }

    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length + 1);
        for(int[] edge : edges) {
            int p1 = ds.getParent(edge[0]);
            int p2 = ds.getParent(edge[1]);
            if(p1 == p2) {
                return new int[]{ edge[0], edge[1]};
            }
            ds.join(edge[0], edge[1]);
        }
        return new int[] {-1, -1};
    }

    
}