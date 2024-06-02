class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length(),min = 27;
        int[] costs = new int[n+1];
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(s.charAt(i) - t.charAt(i));
            costs[i+1] = costs[i] + diff;
            min = Math.min(min,diff);
        }
        if (maxCost >= costs[n]) return n;
        if (maxCost < min) return 0;
        int l = 1, r = n-1;
        while (l < r) {
            int m = (l+r+1)/2;
            if (ok(costs,m, maxCost)) l = m;
            else r = m-1;
        }
        return l;
    }

    //check if substrings within budget
    private boolean ok(int[] costs, int m, int maxCost) {
        for (int i = m; i < costs.length; i++) {
            if (costs[i]-costs[i-m] <= maxCost) return true;
        }
        return false;
    }
}

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        int res = 0,cur = 0;
        for (int r = 0, l = 0; r < n; r++) {
            cur += costs[r];
            while (l <= r && cur > maxCost) cur -= costs[l++];
            if (cur <= maxCost) res = Math.max(res,r-l+1);
        }
        return res;
    }
}