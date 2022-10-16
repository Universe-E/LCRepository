class Solution {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (int i = 0; i < word.length(); i++) cnt[word.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                boolean valid = true;
                cnt[i]--;
                int same = -1;
                for (int j = 0; j < 26; j++) {
                    if (cnt[j] != 0) {
                        if (same == -1) same = cnt[j];
                        if (cnt[j] != same) {
                            valid = false;
                            break;
                        }
                    }
                }
                if (valid) return true;
                cnt[i]++;
            }
        }
        return false;
    }
}