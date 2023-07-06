import java.util.HashMap;

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (answerKey.charAt(i) == 'T') map.put('T',map.getOrDefault('T',0) + 1);
            if (answerKey.charAt(i) == 'F') map.put('F',map.getOrDefault('F',0) + 1);
            while (Math.min(map.getOrDefault('T',0),map.getOrDefault('F',0)) > k) {
                char c = answerKey.charAt(left);
                map.put(c,map.get(c) - 1);
                left++;
            }
            res = Math.max(res,i - left + 1);
        }
        return res;
    }
}

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length(),res = 0;
        int[] cnt = new int[2];//store the count number of T and F
        for (int r = 0,l = 0; r < n; r++) {
            if (answerKey.charAt(r) == 'T') cnt[0]++;
            else cnt[1]++;
            //find the longest valid subarray
            while (l < r && Math.min(cnt[0],cnt[1]) > k) {
                if (answerKey.charAt(l) == 'T') cnt[0]--;
                else cnt[1]--;
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}