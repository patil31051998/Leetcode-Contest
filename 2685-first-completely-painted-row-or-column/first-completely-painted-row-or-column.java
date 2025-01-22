class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> dataIndexMap = new HashMap<>();
        int[] rowCount = new int[mat.length];
        int[] colCount = new int[mat[0].length];
        int i, j;
        for(i = 0; i < mat.length; i++) {
            for(j = 0; j < mat[0].length; j++) {
                dataIndexMap.put(mat[i][j], new int[]{i, j});
            }
        }
        for(i = 0; i < arr.length; i++) {
            int[] ord = dataIndexMap.get(arr[i]);
            rowCount[ord[0]]++;
            colCount[ord[1]]++;
            if(rowCount[ord[0]] ==  mat[0].length || colCount[ord[1]] ==  mat.length) {
                return i;
            }
        }
        return -1;
    }
}