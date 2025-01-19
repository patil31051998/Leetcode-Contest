class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int last, i;
        last = 0;
        for(i = 0; i < derived.length; i++) {
            if(derived[i] == 1) {
                if(last == 0) {
                    last = 1;
                }
                else {
                    last = 0;
                }
            }
        }
        return last == 0;
    }
}