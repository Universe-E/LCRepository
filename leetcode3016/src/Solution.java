import java.util.PriorityQueue;

class Solution {
    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c-'a']++;
        }
        //频次最多的字母放在前面，消耗的按键次数尽量少
        var pq = new PriorityQueue<int[]>((o1,o2) -> (o2[1]-o1[1]));
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            pq.add(new int[]{i,cnt[i]});
        }
        int res = 0, cnt2 = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            cnt2++;
            res += arr[1] * (cnt2 / 8 + (cnt2 % 8 == 0 ? 0 : 1));
        }
        return res;

    }
}