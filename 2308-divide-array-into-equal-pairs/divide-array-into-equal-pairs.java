class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}