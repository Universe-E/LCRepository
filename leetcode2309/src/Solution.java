class Solution {
    public String greatestLetter(String s) {
        int[] cnt1 = new int[26],cnt2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) cnt1[c-'A']++;
            else cnt2[c-'a']++;
        }
        for (int i = 25; i >= 0; i--) {
            if (cnt1[i] != 0 && cnt2[i] != 0) return String.valueOf((char) (i+'A'));
        }
        return "";
    }
}