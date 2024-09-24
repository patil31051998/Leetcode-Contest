class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left, right, count;
        left = right = count = 0;
        while(right < s.length()) {
            if(charSet.contains(s.charAt(right))) {
                while(s.charAt(left) != s.charAt(right)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            else {
                count = Math.max(count, right - left + 1);
            }
            charSet.add(s.charAt(right));
            right++;
        }
        count = Math.max(count, right - left);
        return count;
    }
}