class Solution {
    public long minimumPerimeter(long neededApples) {
        long l = 0,r = 100001;
        while (l < r) {
            long m = (l+r)/2;
            long sum = 2*m*(m+1)*(2*m+1);
            if (sum >= neededApples) r = m;
            else l = m+1;
        }
        return 8*l;
    }
}