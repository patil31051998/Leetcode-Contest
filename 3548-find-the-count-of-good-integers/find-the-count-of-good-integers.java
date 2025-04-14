class Solution {

    private long[] calculateFact() {
        long[] fact = new long[11];
        fact[0] = 1;
        fact[1] = 1;
        for(int i = 2; i <= 10; i++) {
            fact[i] = i * fact[i - 1];
        }
        return fact;
    }

    private long calculatePermutation(int[] freq, int n, long[] fact) {
        long count = fact[n];
        for(int i = 0; i <= 9; i++) {
            count /= fact[freq[i]];
        }
        return count;
    }

    private long countAllPermutation(String no, int n, long[] fact) {
        int[] freq = new int[10];
        for(Character ch : no.toCharArray()) {
            freq[ch - '0']++;
        }
        long validPerm = calculatePermutation(freq, n, fact);
        long inValidPerm = 0L;
        if(freq[0] > 0) {
            freq[0]--;
            inValidPerm = calculatePermutation(freq, n - 1, fact);
        }
        return validPerm - inValidPerm;
    }

    public long countGoodIntegers(StringBuilder no, int n, int k, int ind, Set<Long> visited, long[] fact) {
        if(ind >= (n + 1) / 2) {
            long noVal = Long.valueOf(no.toString());
            if(noVal % k == 0) {
                char[] noChar = no.toString().toCharArray();
                Arrays.sort(noChar);
                Long sortVal = Long.valueOf(new String(noChar));
                if(visited.contains(sortVal)) {
                    return 0L;
                }
                else {
                    visited.add(sortVal);
                    return countAllPermutation(no.toString(), n, fact);
                }
            }
            else {
                return 0L;
            }
        }
        long count = 0L;
        int start = ind == 0 ? 1 : 0;
        for(; start <= 9; start++) {
            no.setCharAt(ind, (char)(start + '0'));
            no.setCharAt(n - 1 - ind, (char)(start + '0'));
            count += countGoodIntegers(no, n, k, ind + 1, visited, fact);
        } 
        no.setCharAt(ind, ' ');
        return count;
    }

    public long countGoodIntegers(int n, int k) {
        long[] fact = calculateFact();
        StringBuilder no = new StringBuilder();
        Set<Long> visited = new HashSet<>();
        for(int i = 0; i < n; i++) {
            no.append(' ');
        }
        return countGoodIntegers(no, n, k, 0, visited, fact); 
    }
}