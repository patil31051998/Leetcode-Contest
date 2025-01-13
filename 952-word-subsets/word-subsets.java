class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCount = new int[26];
        int i, j;
        List<String> result = new ArrayList<>();
        for(i = 0; i < words2.length; i++) {
            int[] currCount = new int[26];
            for(j = 0; j < words2[i].length(); j++) {
                currCount[words2[i].charAt(j) - 'a']++;
            }
            for(j = 0; j < 26; j++) {
                maxCount[j] = Math.max(maxCount[j], currCount[j]);
            }
        }
        for(i = 0; i < words1.length; i++) {
            int[] currCount = new int[26];
            for(j = 0; j < words1[i].length(); j++) {
                currCount[words1[i].charAt(j) - 'a']++;
            }
            if(wordSubsets(currCount, maxCount)) {
                result.add(words1[i]);
            }
        }
        return result;
    }

    private boolean wordSubsets(int[] currCount, int[] maxCount) {
        int i;
        for(i = 0; i < 26; i++) {
            if(currCount[i] < maxCount[i]) {
                return false;
            }
        }
        return true;
    }
}