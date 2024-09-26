class Solution {
    public int characterReplacement(String s, int k) {
        int max, i;
        max = 0;
        for(i = 0; i < 26; i++) {
            max = Math.max(max, characterReplacement(s, k, (char)('A' + i)));
        }
        return max;
    }
    
    private int characterReplacement(String s, int k, char ch) {
        int left, right, max, count;
        left = right = max = count = 0;
        while(right < s.length()) {
            if(s.charAt(right) != ch) {
                if(count == k) {
                    while(s.charAt(left) == ch) {
                        left++;
                    }
                    left++;
                }
                else {
                    count++;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}