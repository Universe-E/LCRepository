class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length, res = 0, l = 0, r = n-1, A = capacityA, B = capacityB;
        while (l <= r) {
            if (l == r) {
                if (A >= B) {
                    if (A < plants[l]) {
                        A = capacityA;
                        res++;
                    }
                    A -= plants[l++];
                }
                else {
                    if (B < plants[r]) {
                        B = capacityB;
                        res++;
                    }
                    B -= plants[r--];
                }
            }
            else {
                if (A < plants[l]) {
                    A = capacityA;
                    res++;
                }
                if (B < plants[r]) {
                    B = capacityB;
                    res++;
                }
                A -= plants[l++];
                B -= plants[r--];
            }
        }
        return res;
    }
}