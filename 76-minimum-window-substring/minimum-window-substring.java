class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();
        for(char ch : t.toCharArray()) {
            tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
        }
        int start, end, minSize, minStart, minEnd;
        start = end = 0;
        minSize = Integer.MAX_VALUE;
        minStart = minEnd = -1;
        while(end < s.length()) {
            sCount.put(s.charAt(end), sCount.getOrDefault(s.charAt(end), 0) + 1);
            if(isSubstringPresent(sCount, tCount)) {
                while(isSubstringPresent(sCount, tCount) && start <= end) {
                    sCount.put(s.charAt(start), sCount.get(s.charAt(start)) - 1);
                    if(minSize > end - start + 1) {
                        minSize = end - start + 1;
                        minStart = start;
                        minEnd = end;
                    }
                    start++;
                }
            }
            end++;
        }
        if(minSize == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minStart, minEnd + 1);
        }
    }

    private boolean isSubstringPresent(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {
        for(Map.Entry<Character, Integer> entry : tCount.entrySet()) {
            if(sCount.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}