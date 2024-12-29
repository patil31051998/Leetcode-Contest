class Solution {
    public long dividePlayers(int[] skill) {
        int[] countArr = new int[2001];
        int i, sum;
        sum = 0;
        for(i = 0; i < skill.length; i++) {
            sum += skill[i];
            countArr[skill[i]]++;
        }
        if(sum % (skill.length / 2) != 0) {
            return -1L;
        }
        int skillValue = sum / (skill.length / 2);
        long chemValue = 0L;
        for(i = 1; i <= skillValue / 2; i++) {
            if(countArr[i] != 0 && countArr[skillValue - i] != 0) {
                if(countArr[i] == countArr[skillValue - i]) {
                    if(i * 2 == skillValue) {
                        if(countArr[i] % 2 == 0) {
                            chemValue += 1L * i * i * (countArr[i] / 2);
                        }
                        else {
                            return -1L;
                        }
                    }
                    else {
                        chemValue += 1L * i * (skillValue - i) * countArr[i];
                    }
                }
                else {
                    return -1L;
                }
            }
            else if(countArr[i] == 0 && countArr[skillValue - i] == 0) {
                continue;
            }
            else {
                return -1L;
            }
        }
        return chemValue;
    }
}