import java.util.PriorityQueue;

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            cnt[c-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> (o2[1]-o1[1]));
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) pq.add(new int[] {i,cnt[i]});
        }
        assert !pq.isEmpty();
        if (pq.peek()[1] > n/2 + 1) return "";
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            int[] a = pq.poll(), b = pq.poll();
            assert b != null;
            sb.append((char) ('a'+a[0]));
            sb.append((char) ('a'+b[0]));
            if (--a[1] > 0) pq.add(a);
            if (--b[1] > 0) pq.add(b);
        }
        if (pq.isEmpty()) return sb.toString();
        if (pq.peek()[1] > 1) return "";
        return sb.append((char) ('a'+pq.peek()[0])).toString();
    }
}