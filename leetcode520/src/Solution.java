class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int up = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) up++;
        }
        return up == 0 || up == n || (up == 1 && Character.isUpperCase(word.charAt(0)));
    }
}