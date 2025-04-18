class Solution {
    public String countAndSay(int n) {
        String prev = "1";
        int i, j;
        for(i = 2; i <= n; i++) {
            StringBuilder curr = new StringBuilder("");
            char last = prev.charAt(0);
            int count = 1;
            for(j = 1; j < prev.length(); j++) {
                if(prev.charAt(j) == last) {
                    count++;
                }
                else {
                    curr.append(count + "" + last);
                    last = prev.charAt(j);
                    count = 1;
                }
            }
            curr.append(count + "" + last);
            prev = curr.toString();
        }
        return prev;
    }
}