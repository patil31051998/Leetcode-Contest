class Solution {
    public boolean canConstruct(String s, int k) {
        int[] countArr = new int[26];
        int i;
        int oddCount = 0;
        if(s.length() < k) {
            return false;
        }
        if(s.length() == k) {
            return true;
        }
        for(i = 0; i < s.length(); i++) {
            countArr[s.charAt(i) - 'a']++;
        }
        for(i = 0; i < 26; i++) {
            if(countArr[i] % 2 == 1) {
                oddCount++;
            }
        }
        if(oddCount > k) {
            return false;
        }
        else {
            return true;
        }
    }
}