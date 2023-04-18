class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0x3f3f3f3f;
        while (l < r) {
            int mid = (l + r) / 2;
            long time = 0;
            for (int pile : piles) {
                //time += pile / mid + (pile%mid == 0 ? 0 : 1);
                //对于非零可以重写成如下形式：
                time += (pile - 1) / mid + 1;
            }
            if (time > h) l = mid + 1;
            else if (time < h) r = mid;
            else r = mid;
        }
        return l;
    }
}