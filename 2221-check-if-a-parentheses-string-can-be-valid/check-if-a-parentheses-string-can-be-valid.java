class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 == 1) {
            return false;
        }
        Stack<Integer> blockedOpen = new Stack<>();
        Stack<Integer> unblocked = new Stack<>(); 
        int i;
        for(i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')' && locked.charAt(i) == '1') {
                if(blockedOpen.isEmpty()) {
                    if(unblocked.isEmpty()) {
                        return false;
                    }
                    else {
                        unblocked.pop();
                    }
                }
                else {
                    blockedOpen.pop();
                }
            }
            else if(locked.charAt(i) == '0') {
                unblocked.push(i);
            }
            else {
                blockedOpen.push(i);
            }
        }
        while(!blockedOpen.isEmpty() && !unblocked.isEmpty() && unblocked.peek() > blockedOpen.peek()) {
            blockedOpen.pop();
            unblocked.pop();
        }
        return blockedOpen.isEmpty();
    }
}