class Solution {
    public int minimumLength(String s) {
        int[] count = new int[26];
        int res = 0;
        int i;
        for(i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for(i = 0; i < 26; i++) {
            if(count[i] != 0 && count[i] % 2 == 0) {
                res += 2;
            }
            else if(count[i] % 2 == 1) {
                res += 1;
            }
        }
        return res;
    }
}