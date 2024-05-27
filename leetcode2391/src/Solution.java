class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int gar = 0,m = 0,g = 0,p = 0,n = garbage.length,dis = 0;
        for (int i = 0; i < n; i++) {
            if (garbage[i].contains("M")) m = dis;
            if (garbage[i].contains("G")) g = dis;
            if (garbage[i].contains("P")) p = dis;
            gar += garbage[i].length();
            if (i != n-1) dis += travel[i];
        }
        return gar + m + g + p;
    }
}