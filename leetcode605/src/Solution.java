class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cur = n;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (flowerbed.length == 1) flowerbed[i] = 1;
                else if (i == 0 && flowerbed[i + 1] == 0) flowerbed[i] = 1;
                else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) flowerbed[i] = 1;
                else if (i != 0 && i != flowerbed.length - 1 &&
                        flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) flowerbed[i] = 1;
                if (flowerbed[i] == 1) cur--;
            }
        }
        return cur <= 0;
    }
}