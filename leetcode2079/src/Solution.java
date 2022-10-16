class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0, n = plants.length;
        int cur = capacity;
        for (int i = 0; i < n; i++) {
            if (cur >= plants[i]) {
                res++;
                cur -= plants[i];
            }
            else {
                res += 2 * i + 1;
                cur = capacity - plants[i];
            }
        }
        return res;
    }
}