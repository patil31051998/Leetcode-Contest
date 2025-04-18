class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        String sayData = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder("");
        char prev = sayData.charAt(0);
        int count = 1;
        int i;
        for(i = 1; i < sayData.length(); i++) {
            if(prev == sayData.charAt(i)) {
                count++;
            }
            else {
                sb.append(count + "" + prev);
                prev = sayData.charAt(i);
                count = 1;
            }
        }
        sb.append(count + "" + prev);
        // System.out.println(sb.toString());
        return sb.toString();
    }
}