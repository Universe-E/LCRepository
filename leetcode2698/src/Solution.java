class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int m = i*i;
            if (dfs(String.valueOf(m),0,0,i)) res += m;
        }
        return res;
    }

    private boolean dfs(String s,int idx,int cur,int i) {
       if (idx == s.length()) return cur == i;
       for (int j = idx; j < s.length(); j++) {
            int t = Integer.parseInt(s.substring(idx,j+1));
            if (dfs(s,j+1,cur+t,i)) return true;
       }
       return false;
    }
}

class Solution {
    public int punishmentNumber(int n) {
        if (n < 9){
            return 1;
        } else if (n < 10){
            return 82;
        } else if (n < 36){
            return 182;
        } else if (n < 45){
            return 1478;
        } else if (n < 55){
            return 3503;
        } else if (n < 82){
            return 6528;
        } else if (n < 91){
            return 13252;
        } else if (n < 99){
            return 21533;
        } else if (n < 100){
            return 31334;
        } else if (n < 235){
            return 41334;
        } else if (n < 297){
            return 96559;
        } else if (n < 369){
            return 184768;
        } else if (n < 370){
            return 320929;
        } else if (n < 379){
            return 457829;
        } else if (n < 414){
            return 601470;
        } else if (n < 657){
            return 772866;
        } else if (n < 675){
            return 1204515;
        } else if (n < 703){
            return 1660140;
        } else if (n < 756){
            return 2154349;
        } else if (n < 792){
            return 2725885;
        } else if (n < 909){
            return 3353149;
        } else if (n < 918){
            return 4179430;
        } else if (n < 945){
            return 5022154;
        } else if (n < 964){
            return 5915179;
        } else if (n < 990){
            return 6844475;
        } else if (n < 991){
            return 7824575;
        } else if (n < 999){
            return 8806656;
        } else if (n < 1000){
            return 9804657;
        } else
            return 10804657;

    }
}