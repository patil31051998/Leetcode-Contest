class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] nextValidDay = fillNextValidDay(days);
        int[] dp = new int[days[days.length - 1] + 1];
        Arrays.fill(dp, -1);
        // System.out.println(Arrays.toString(nextValidDay));
        return mincostTickets(nextValidDay, costs, days[0], days[days.length - 1], dp);
    }

    public int mincostTickets(int[] nextValidDay, int[] costs, int currDay, int lastDay, int[] dp) {
        // System.out.println(currDay);
        if(currDay > lastDay) {
            return 0;
        }
        if(dp[currDay] != -1) {
            return dp[currDay];
        }
        int dayCost = costs[0] + mincostTickets(nextValidDay, costs, nextValidDay[currDay], lastDay, dp);
        int weekCost = costs[1];
        if(currDay + 7 <= lastDay) {
            weekCost += mincostTickets(nextValidDay, costs, nextValidDay[currDay + 6], lastDay, dp);
        }
        int monthCost = costs[2];
        if(currDay + 30 <= lastDay) {
            monthCost += mincostTickets(nextValidDay, costs, nextValidDay[currDay + 29], lastDay, dp);
        }
        // System.out.println(currDay + ":" + dayCost + ":" + weekCost + ":" + monthCost);
        return dp[currDay] = Math.min(dayCost, Math.min(weekCost, monthCost));
    }

    private int[] fillNextValidDay(int[] days) {
        int[] nextValidDay = new int[days[days.length - 1] + 1];
        int daysInd = 0;
        int i;
        for(i = 1; i < nextValidDay.length - 1; i++) {
            if(i < days[daysInd]) { 
                nextValidDay[i] = days[daysInd];
            }
            else {
                daysInd++;
                nextValidDay[i] = days[daysInd];
            }
        }
        nextValidDay[nextValidDay.length - 1] = nextValidDay.length;
        return nextValidDay;  
    }
}