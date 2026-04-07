class Solution {
    public int mirrorFrequency(String s) {
        Map<Character, Integer> countMap = new  HashMap<>();
        Set<Character> usedMirror = new HashSet<>();
        int res = 0;
        for(Character ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char key = entry.getKey();
            if(usedMirror.contains(key)) {
                continue;
            }
            char mirrorKey;
            if(key >= 'a' && key <= 'z') {
                mirrorKey = (char)('z' - key + 'a');
            }
            else {
                mirrorKey = (char)('9' - key + '0');
            }
            // System.out.println(key + ":" + mirrorKey);
            res += Math.abs(countMap.getOrDefault(key, 0) - countMap.getOrDefault(mirrorKey, 0));
            usedMirror.add(mirrorKey);
        }
        return res;
    }
}