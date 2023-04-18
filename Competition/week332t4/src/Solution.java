class Solution {
    public int minimumScore(String s, String t) {
        int n = s.length(), tn = t.length(),p = 0;
        //l[i]和r[i]分别表示s[0,i]和s[i,tn-1]区间匹配到t的前缀（后缀）长度
        int[] l = new int[n], r = new int[n];
        for (int i = 0; i < n; i++) {
            if (p < tn && s.charAt(i) == t.charAt(p)) p++;
            l[i] = p;
        }
        p = 0;
        for (int i = n-1; i >= 0; i--) {
            if (p < tn && s.charAt(i) == t.charAt(tn-1-p)) p++;
            r[i] = p;
        }
        //处理完l和r后，遍历s，找到某个i使得l[i]+r[i+1]最大，此时对应需要删除的子串长度最短
        int min = tn;
        for (int i = 0; i < n-1; i++) {
            int cur = l[i]+r[i+1];
            if (cur >= tn) return 0;//此时不用删除，因为此时已经证明t已经是s的子串
            min = Math.min(min,tn-cur);
        }
        //由于上述遍历仅考虑l[i]和r[i+1]均存在的情况（从l[0],r[1]到l[n-2],r[n-1]）
        //因此还需要单独讨论r[0]和l[n-1]的情况
        min = Math.min(min,Math.min(tn-l[n-1],tn-r[0]));
        return min;
    }
}