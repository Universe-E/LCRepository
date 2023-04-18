import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> words = new ArrayList<>();
        int n2 = words2.length;
        int[][] cnt2 = new int[n2][26];
        int[] maxCnt = new int[26];//每个cnt2[i]中，每个字母的最大频率
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < words2[i].length(); j++) {
                cnt2[i][words2[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                maxCnt[j] = Math.max(maxCnt[j],cnt2[i][j]);
            }
        }
        for (String word : words1) {
            int[] cnt1 = new int[26];
            for (int i = 0; i < word.length(); i++) {
                cnt1[word.charAt(i)-'a']++;
            }
            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (cnt1[i] < maxCnt[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) words.add(word);
        }
        return words;
    }
}