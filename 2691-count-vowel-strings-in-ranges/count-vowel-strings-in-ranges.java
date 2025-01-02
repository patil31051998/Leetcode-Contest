class Solution {

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||
            ch == 'u'; 
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixVowSum = new int[words.length];
        int[] res = new int[queries.length];
        int i, curr;
        curr = 0;
        for(i = 0; i < words.length; i++) {
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                curr++;
            }
            prefixVowSum[i] = curr;
        }
        for(i = 0; i < queries.length; i++) {
            int left = queries[i][0] == 0 ? 0 : prefixVowSum[queries[i][0] - 1];
            int right = prefixVowSum[queries[i][1]];
            res[i] = right - left;
        }
        return res;
    }
}