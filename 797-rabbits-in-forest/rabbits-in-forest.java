class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int i;
        int res = 0;
        for(i = 0; i < answers.length; i++) {
            if(answers[i] == 0) {
                res++;
                continue;
            }
            countMap.put(answers[i], countMap.getOrDefault(answers[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int val = entry.getKey() + 1;
            if(entry.getValue() % val == 0) {
                res += (entry.getValue() / val) * val;
            }
            else {
                res += ((entry.getValue() / val) + 1) * val;
            }
        }
        return res;
    }
}