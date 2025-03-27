class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int count, val, i, currCount;
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        count = val = -1;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() > count) {
                count = entry.getValue();
                val = entry.getKey();
            }
        }
        currCount = 0;
        for(i = 0; i < nums.size() - 1; i++) {
            if(val == nums.get(i)) {
                currCount++;
            }
            // System.out.println((2 * currCount) + "::" + (i + 1));
            // System.out.println((2 * (count - currCount)) + "::" + (nums.size() - i - 1));
            if((2 * currCount > (i + 1)) && (2 * (count - currCount) > (nums.size() - i - 1))) {
                return i;
            }
        }
        return -1;
    }
}