class Solution {
    public int[] constructRectangle(int area) {
        int width = 1,length = 1;
        for (int i = (int)Math.sqrt(area); i >= 1; i--) {
            if (area % i == 0) {
                length = area / i;
                width = i;
                break;
            }
        }
        return new int[] {length,width};
    }
}
