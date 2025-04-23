class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        int max = 0;
        int count = 0;
        int i;
        for(i = 1; i <= n; i++) {
            int sum = getSum(i);
            sumCountMap.put(sum, sumCountMap.getOrDefault(sum, 0) + 1);
            max = Math.max(max, sumCountMap.get(sum));
        }
        for(Map.Entry<Integer, Integer> entry : sumCountMap.entrySet()) {
            if(entry.getValue() == max) {
                count++;
            }
        }
        return count;
    }

    private int getSum(int no) {
        int sum = 0;
        while(no > 0) {
            sum += no % 10;
            no = no / 10;
        }
        return sum;
    }
}