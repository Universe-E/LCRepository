class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0,r = n-1;
        while (l < r) {
            //suppose h index begin in index m
            int m = (l+r)/2;
            //m can be included
            if (citations[m] >= n-m) r = m;
            // m cannot be included
            else l = m+1;
        }
        return Math.min(citations[l],n-l);
    }
}
