class Solution {
    public int countAsterisks(String s) {
        int cnt = 0,res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='|') cnt++;
            if (cnt%2==0 && c == '*') res++;
        }
        return res;
    }
}