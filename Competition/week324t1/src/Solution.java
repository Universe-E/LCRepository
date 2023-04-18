class Solution {
    public int similarPairs(String[] words) {
        int n = words.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isSimilar(words[i],words[j])) res++;
            }
        }
        return res;
    }

    private boolean isSimilar(String word1, String word2) {
        int[] w1 = new int[26], w2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            if (w1[c-'a'] == 0) w1[c-'a'] = 1;
        }
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            if (w2[c-'a'] == 0) w2[c-'a'] = 1;
        }
        for (int i = 0; i < 26; i++) {
            if (w1[i] != w2[i]) return false;
        }
        return true;
    }
}