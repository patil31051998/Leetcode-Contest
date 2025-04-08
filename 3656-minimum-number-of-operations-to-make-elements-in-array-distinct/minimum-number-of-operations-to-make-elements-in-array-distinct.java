class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> dupSet = new HashSet<>();
        int i, res;
        res = 0;
        for(i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if(countMap.get(nums[i]) > 1) {
                dupSet.add(nums[i]);
            }
        }
        i = 0;
        while(!dupSet.isEmpty()) {
            int j = i;
            for(; j < i + 3 && j < nums.length; j++) {
                countMap.put(nums[j], countMap.get(nums[j]) - 1);
                if(countMap.get(nums[j]) == 1) {
                    dupSet.remove(nums[j]);
                }
            }
            i = i + 3;
            res++;
        }
        return res;
    }
}