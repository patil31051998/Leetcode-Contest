class Solution {

    private final int MOD = (int)Math.pow(10, 9) + 7;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[][] transformMat = new long[26][26];
        long[] finalMat = new long[26];
        int i, j;
        long res = 0L;
        for(i = 0; i < 26; i++) {
            int len = nums.get(i);
            for(j = 1; j <= len; j++) {
                int idx = (i + j) % 26;
                transformMat[i][idx]++;
            }
        }
        long[] curr = new long[26];
        for(i = 0; i < s.length(); i++) {
            curr[s.charAt(i) -'a']++;
        }
        long[][] expMatrix = matrixExponentiation(transformMat, t);
        for(i = 0; i < 26; i++) {
            for(j = 0; j < 26; j++) {
                finalMat[i] = (finalMat[i] + curr[j] * expMatrix[j][i]);
            }
        }
        for(i = 0; i < 26; i++) {
            res = (res + finalMat[i]) % MOD;
        }
        return (int)res;
    }


    private long[][] matrixExponentiation(long[][] mat, int pow) {
        long[][] res = getIndentityMatrix(mat.length);
        while(pow > 0) {
            if(pow % 2 == 1) {
                res = getMatrixMultiplication(res, mat);
            }
            pow = pow / 2;
            mat = getMatrixMultiplication(mat, mat);
        }
        return res;
    }

    private long[][] getIndentityMatrix(int len) {
        int i;
        long[][] indentityMat = new long[len][len];
        for(i = 0; i < len; i++) {
            indentityMat[i][i] = 1;
        }
        return indentityMat;
    }

    private long[][] getMatrixMultiplication(long[][] mat1, long[][] mat2) {
        int i, j, k;
        long[][] res = new long[mat1.length][mat2.length];
        for(i = 0; i < mat1.length; i++) {
            for(j = 0; j < mat2.length; j++) {
                for(k = 0; k < mat1[0].length; k++) {
                    res[i][j] = (res[i][j] + mat1[i][k] * mat2[k][j]) % MOD;
                }
            }
        }
        return res;
    }
}