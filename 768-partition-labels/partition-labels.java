class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] start = new int[26];
        int[] end = new int[26];
        int i;
        List<Integer> result = new ArrayList<>();
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for(i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            start[ch - 'a'] = start[ch - 'a'] == -1 ? i : start[ch - 'a'];
            end[ch - 'a'] = i;
        }
        int currStart, currEnd;
        currStart = 0;
        currEnd = end[s.charAt(0) - 'a'];
        for(i = 0; i < s.length() - 1; i++) {
            if(i == currEnd) {
                result.add(currEnd - currStart + 1);
                currStart = i + 1;
                currEnd = end[s.charAt(i + 1) - 'a'];
            }
            else {
                currEnd = Math.max(currEnd, end[s.charAt(i) - 'a']);
            }
        }
        result.add(i - currStart + 1);
        return result;
    }
}