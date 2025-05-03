class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minCount = Integer.MAX_VALUE;
        int i, j;
        int[] topCount = new int[7];
        int[] bottomCount = new int[7];
        for(i = 0; i < tops.length; i++) {
            topCount[tops[i]]++;
            bottomCount[bottoms[i]]++;
        }
        for(i = 1; i <= 6; i++) {
            if(topCount[i] + bottomCount[i] >= tops.length) {
                for(j = 0; j < tops.length; j++) {
                    if(tops[j] != i && bottoms[j] != i) {
                        break;
                    }
                }
                if(j == tops.length) {
                    minCount = Math.min(minCount, 
                        Math.min(tops.length - topCount[i], bottoms.length - bottomCount[i]));
                }
            }
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
}