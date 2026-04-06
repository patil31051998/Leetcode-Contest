class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        Set<Integer> data = new HashSet<>();
        for(int i = 0; i < A.length; i++) {
            data.add(A[i]);
            int count = 0;
            for(int j = 0; j <= i; j++) {
                if(data.contains(B[j])) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}