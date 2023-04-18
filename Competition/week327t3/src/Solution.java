class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            cnt1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            cnt2[word2.charAt(i) - 'a']++;
        }
        int c1 = getCnt(cnt1), c2 = getCnt(cnt2);
        //逐个交换比较
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (cnt1[i] == 0 || cnt2[j] == 0) continue;
                //i和j交换
                cnt1[i]--;
                cnt1[j]++;
                cnt2[i]++;
                cnt2[j]--;
                if (getCnt(cnt1)==getCnt(cnt2)) return true;
                //返回原样
                cnt1[i]++;
                cnt1[j]--;
                cnt2[i]--;
                cnt2[j]++;
            }
        }
        return false;
    }

    private int getCnt(int[] cnt) {
        int res = 0;
        for (int value : cnt) if (value != 0) res++;
        return res;
    }
}