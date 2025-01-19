class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int last, i;
        last = 0;
        for(i = 0; i < derived.length; i++) {
            if(derived[i] == 1) {
                last = ~last;
            }
        }
        return last == 0;
    }
}