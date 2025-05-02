class Solution {
    public String pushDominoes(String dominoes) {
        List<Integer> leftDominoIdx = new ArrayList<>();
        List<Integer> rightDominoIdx = new ArrayList<>();
        StringBuilder leftDomino = new StringBuilder(dominoes);
        StringBuilder rightDomino = new StringBuilder(dominoes);
        StringBuilder result = new StringBuilder("");
        int i;
        for(i = 0; i < dominoes.length(); i++) {
            if(dominoes.charAt(i) == 'L') {
                leftDominoIdx.add(i);
            }
            else if(dominoes.charAt(i) == 'R') {
                rightDominoIdx.add(i);
            }
        }
        for(int idx : leftDominoIdx) {
            int curr = idx - 1;
            while(curr >= 0 && dominoes.charAt(curr) == '.') {
                leftDomino.setCharAt(curr, (char)(idx - curr + '0'));
                curr--;
            }
        }
        for(int idx : rightDominoIdx) {
            int curr = idx + 1;
            while(curr < dominoes.length() && dominoes.charAt(curr) == '.') {
                rightDomino.setCharAt(curr, (char)(curr - idx + '0'));
                curr++;
            }
        }
        for(i = 0; i < dominoes.length(); i++) {
            if(dominoes.charAt(i) != '.' ) {
                result.append(dominoes.charAt(i));
            }
            else if(leftDomino.charAt(i) == '.' && rightDomino.charAt(i) == '.') {
                result.append(".");
            }
            else if(leftDomino.charAt(i) == rightDomino.charAt(i)) {
                result.append(".");
            }
            else if(leftDomino.charAt(i) != '.' && rightDomino.charAt(i) != '.') {
                result.append(leftDomino.charAt(i) < rightDomino.charAt(i) ? 'L' : 'R');
            }
            else {
                result.append(leftDomino.charAt(i) != '.' ? 'L': 'R');
            }
        }
        return result.toString();
    }
}