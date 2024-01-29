class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0,cur = 0,j = 25,lastId = -1; i < n; i++) {
            // find current char
            while (j >= 0 && (cnt[j] == 0 || (cur == repeatLimit && j == lastId))) j--;
            //no char matched, return sb
            if (j == -1) return sb.toString();
            //recalculate cur
            if (cur == repeatLimit || j != lastId) cur = 1;
            else cur++;
            lastId = j;
            sb.append((char) ('a'+j));
            cnt[j]--;

            j = 25;
        }
        return sb.toString();
    }
}