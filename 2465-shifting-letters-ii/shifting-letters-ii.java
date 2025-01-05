class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] data = new int[s.length() + 1];
        int i, diff;
        for(i = 0; i < shifts.length; i++) {
            if(shifts[i][2] == 1) {
                data[shifts[i][1] + 1] += 1; 
                data[shifts[i][0]] -= 1;  
            }
            else {
               data[shifts[i][1] + 1] -= 1; 
               data[shifts[i][0]] += 1; 
            }  
        }
        StringBuilder sb = new StringBuilder("");
        diff = 0;
        for(i = data.length - 1; i > 0; i--) {
            diff = diff + data[i];
            int netDiff = (diff % 26 + 26) % 26;
            int curr = s.charAt(i - 1) - 'a';
            sb.append((char)((curr + netDiff) % 26 + 'a'));
        }
        return sb.reverse().toString();
    }
}