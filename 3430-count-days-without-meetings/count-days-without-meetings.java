class Solution {
    public int countDays(int days, int[][] meetings) {
        List<int[]> mergedDays = new ArrayList<>();
        Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]);
        int low = meetings[0][0];
        int high = meetings[0][1];
        int i;
        int count = 0;
        for(i = 1; i < meetings.length; i++) {
            if(meetings[i][0] > high) {
                mergedDays.add(new int[] { low, high });
                low = meetings[i][0];
                high = meetings[i][1];
            }
            else {
                high = Math.max(high, meetings[i][1]);
            }
        }
        mergedDays.add(new int[] { low, high });
        for(int[] mergedDay : mergedDays) {
            count += mergedDay[1] - mergedDay[0] + 1;
        }
        return days - count;
    }
}