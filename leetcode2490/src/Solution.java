class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        int n = s.length;
        for (int i = 0; i < n; i++) {
            int len = s[i].length(),pre = (i-1+n)%n;
            if (s[i].charAt(0) != s[pre].charAt(s[pre].length()-1)) return false;
        }
        return true;
    }
}