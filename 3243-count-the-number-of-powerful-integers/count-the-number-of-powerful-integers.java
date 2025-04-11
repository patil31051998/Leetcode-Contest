class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String startStr = String.valueOf(start - 1);
        String finishStr = String.valueOf(finish);
        long sVal = Long.parseLong(s);

        int startDigitCount = startStr.length();
        int finishDigitCount = finishStr.length();

        long finishCount = sVal > finish ? 0L : numberOfPowerfulInt(finishStr, finishDigitCount, limit, s);
        long startCount = sVal >= start ? 0L : numberOfPowerfulInt(startStr, startDigitCount, limit, s);

        return  finishCount - startCount;
    
    }

    private long numberOfPowerfulInt(String currStr, int currDigitCount, int limit, String s) {
        long[][] dp = new long[17][2];
        for(long[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        long res = numberOfPowerfulInt(currStr, currDigitCount, 0, true, limit, s, dp);
        if(isSubstractionRequired(currStr, currDigitCount, limit, s)) {
            res--;
        }
        return res;
    }

    private long numberOfPowerfulInt(String currStr, int currDigitCount, int ind, boolean isTight, int limit, String s, long[][] dp) {
        if(currDigitCount == ind) {
            return 1;
        }
        if(dp[ind][isTight ? 1 : 0] != -1L) {
            return dp[ind][isTight ? 1 : 0];
        }
        int low, high, i;
        int suffixLen = s.length();
        if (ind >= currDigitCount - suffixLen) {
            int suffixIdx = ind - (currDigitCount - suffixLen);
            low = high = s.charAt(suffixIdx) - '0';
        } else {
            high = isTight ? Math.min(limit, currStr.charAt(ind) - '0') : limit;
            low = 0;
        }

        long total  = 0L;
        for (int digit = low; digit <= high; ++digit) {
            boolean newTight = isTight && (digit == currStr.charAt(ind) - '0');
            total += numberOfPowerfulInt(currStr, currDigitCount, ind + 1, newTight, limit, s, dp);
        }
        return dp[ind][isTight ? 1 : 0]  = total ;
    }

    private boolean isSubstractionRequired(String currStr, int currDigitCount, int limit, String s) {
        if (currDigitCount < currStr.length()) return false;
        Long currSuffix = Long.parseLong(currStr.substring(currDigitCount - s.length()));
        Long suffix = Long.parseLong(s);
        if(currSuffix >= suffix) {
            return false;
        }
        for(int i = 0; i < currDigitCount - s.length(); i++) {
            if(currStr.charAt(i) - '0' > limit) {
                return false;
            }
        }
        return true;
    }

    
}