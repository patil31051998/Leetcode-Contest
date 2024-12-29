class Solution {
    public long dividePlayers(int[] skill) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int i, sum;
        sum = 0;
        for(i = 0; i < skill.length; i++) {
            sum += skill[i];
            countMap.put(skill[i], countMap.getOrDefault(skill[i], 0) + 1);
        }
        if(sum % (skill.length / 2) != 0) {
            return -1L;
        }
        int target = sum / (skill.length / 2);
        long chemValue = 0L;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(!countMap.containsKey(target - entry.getKey()) 
                || !(countMap.get(entry.getKey()).equals(countMap.get(target - entry.getKey())))) {
                return -1L;
            }
            else {
                chemValue +=  1L * entry.getKey() * (target - entry.getKey()) * entry.getValue();
            }
        }
        return chemValue / 2;
    }
}