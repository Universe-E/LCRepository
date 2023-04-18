

class Solution {
    public int numSteps(String s) {
        char[] cs = new char[s.length()+1];
        System.arraycopy(s.toCharArray(),0,cs,1,s.length());
        cs[0] = '0';
        int n = cs.length;
        int cnt = 0,i = n-1;
        while (i > 0) {
            if (i == 1) {
                if (cs[i] == '1') break;
            }
            if (cs[i] == '0') {
                cnt++;
                i--;
            }
            else {
                int j = i;
                while (cs[j] == '1') {
                    cs[j] = '0';
                    j--;
                }
                cs[j] = '1';
                cnt++;
            }
        }
        return cnt;
    }
}