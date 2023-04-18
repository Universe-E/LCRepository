import java.util.Arrays;

class Solution {
    int res = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        //先计数
        int[] cnt = new int[26];
        for (char c : letters) {
            cnt[c-'a']++;
        }
        bt(words,cnt,score,0,0);
        return res;
    }

    private void bt(String[] words, int[] cnt, int[] score, int idx, int cur) {
        for (int i = idx; i < words.length; i++) {
            int[] cnt2 = Arrays.copyOf(cnt,cnt.length);
            int curScore = valid(words[i],cnt2,score);
            if (curScore != -1) bt(words,cnt2,score,i+1,cur+curScore);
        }
        res = Math.max(res,cur);
    }

    //判断能否取当前单词，如果能，返回计算分数，如果不能，返回-1
    private int valid(String word,int[] cnt,int[] score) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i)-'a';
            if (cnt[j] == 0) return -1;
            cnt[j]--;
            res += score[j];
        }
        return res;
    }
}