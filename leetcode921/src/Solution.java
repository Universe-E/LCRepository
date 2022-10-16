class Solution {
    public int minAddToMakeValid(String s) {
        //lp代表当前括号左侧有多少能匹配的左括号
        //如果当前右括号左侧没有能匹配的左括号，则overflow加1，否则lp减1
        int overflow = 0, lp = 0,n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') lp++;
            else {
                if (lp == 0) overflow++;
                else lp--;
            }
        }
        return overflow + lp;
    }
}