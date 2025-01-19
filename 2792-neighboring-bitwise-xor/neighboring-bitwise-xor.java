class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int last, i;
        last = 0;
        for(i = 0; i < derived.length; i++) {
           last = last ^ derived[i];
        }
        return last == 0;
    }
}