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