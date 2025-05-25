class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> currWords = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        int charCount = 0;
        boolean isEqualOddCount = false;
        for(String word : words) {
            currWords.put(word, currWords.getOrDefault(word, 0) + 1);
        }
        // System.out.println(currWords);
        for(Map.Entry<String, Integer> entry : currWords.entrySet()) {
            if(usedWords.contains(entry.getKey())) {
                continue;
            }
            String word = entry.getKey();
            String revWord = word.charAt(1) + "" + word.charAt(0);
            boolean isEqualChar = word.equals(revWord);
            if(isEqualChar) {
                if(entry.getValue() % 2 == 0) {
                    charCount += (entry.getValue() * 2); 
                }
                else {
                    isEqualOddCount = true;
                    charCount += Math.max(0, (entry.getValue() - 1) * 2);
                }
            } 
            else {
                if(currWords.containsKey(revWord)) {
                    usedWords.add(word);
                    usedWords.add(revWord);
                    charCount += (Math.min(entry.getValue(), currWords.get(revWord))  * 4); 
                }
            }
        }
        charCount += (isEqualOddCount ? 2 : 0); 
        return charCount;
    }
}