class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        int prev = groups[0];
        int i;
        for(i = 1; i < groups.length; i++) {
            if(groups[i] == prev) {
                continue;
            } else {
                result.add(words[i]);
                prev = groups[i];
            }
        }
        return result;
    }
}