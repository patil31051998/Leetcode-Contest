class Solution {
    public int totalSteps(int[] nums) {
       int maxSteps = 0;
       Stack<Pair<Integer, Integer>> stack = new Stack<>();
       stack.push(new Pair(nums[nums.length - 1], 0));
       int n = nums.length - 1;
       for(int i = n - 1; i >= 0; i--) {
            int count = 0;
            while(!stack.isEmpty() && nums[i] > stack.peek().getKey()) {
                count = Math.max(count + 1, stack.peek().getValue());
                stack.pop();
            }
            maxSteps = Math.max(maxSteps, count);
            stack.push(new Pair(nums[i], count));
       }
       return maxSteps;
    }
}