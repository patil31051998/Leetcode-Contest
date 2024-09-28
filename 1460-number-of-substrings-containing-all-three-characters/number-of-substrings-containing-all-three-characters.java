class Solution {
    public int numberOfSubstrings(String s) {
        int[] charCount = new int[3];
        int left, right, count;
        left = right = count = 0;
        while(right < s.length()) {
            char ch = s.charAt(right);
            charCount[ch - 'a']++;
            if(isAllCharPresent(charCount)) {
                while(isAllCharPresent(charCount)) {
                    count += s.length() - right;
                    charCount[s.charAt(left) - 'a']--;
                    left++;
                }
            }
            right++;
        }
        return count;
    }
    
    private boolean isAllCharPresent(int[] charCount) {
        return charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0;
    }
}