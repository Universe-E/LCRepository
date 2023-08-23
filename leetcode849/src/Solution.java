import java.util.TreeSet;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) set.add(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                if (set.lower(i) == null) res = Math.max(res,set.higher(i)-i);
                else if (set.higher(i) == null) res = Math.max(res, i-set.lower(i));
                else res = Math.max(res,Math.min(i-set.lower(i),set.higher(i)-i));
            }
        }
        return res;
    }
}

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length,l = 0;
        while (l < n && seats[l] == 0) l++;
        int res = l;
        while (l < n) {
            int r = l+1;
            while (r < n && seats[r] == 0) r++;
            if (r == n) res = Math.max(res,n-l-1);
            else res = Math.max(res,(r-l)/2);
            l = r;
        }
        return res;
    }
}