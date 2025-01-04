class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] start = new int[26];
        int[] end = new int[26];
        int i;
        int res = 0;
        Arrays.fill(start, -1);
        Arrays.fill(end, Integer.MAX_VALUE);
        for(i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if(start[ch] == -1) {
                start[ch] = i;
                end[ch] = i;
            }
            else {
                end[ch] = i;
            }
        }
        for(i = 0; i < 26; i++) {
            if(start[i] != -1 && end[i] - start[i] >= 2) {
                res += countUniqueChar(start[i] + 1, end[i] - 1, s);
            }
        }
        return res;
    }

    private int countUniqueChar(int start, int end, String s) {
        Set<Character> unique = new HashSet<>();
        int i;
        for(i = start; i <= end; i++) {
            unique.add(s.charAt(i));
        }
        return unique.size();
    }
}