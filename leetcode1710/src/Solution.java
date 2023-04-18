import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(o1,o2) -> (o2[1]-o1[1]));
        int n = boxTypes.length;
        int res = 0,size = 0;
        for (int i = 0; i < n; i++) {
            while (size < truckSize && boxTypes[i][0] != 0) {
                res += boxTypes[i][1];
                size++;
                boxTypes[i][0]--;
            }
        }
        return res;
    }
}