import java.util.Arrays;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, (o1,o2) -> (o1[0]==o2[0]) ? (o1[1]-o2[1]) : (o1[0]-o2[0]));
        int[] start = coordinates[0],end = coordinates[1];
        int dx = end[0]-start[0],dy = end[1]-start[1];
        for (int i = 2; i < coordinates.length; i++) {
            int dx2 = coordinates[i][0]-coordinates[i-1][0],dy2 = coordinates[i][1]-coordinates[i-1][1];
            if (dx == 0) {
                if (dx2 != 0) return false;
            }
            else if (dy == 0) {
                if (dy2 != 0) return false;
            }
            else {
                if (dx*dy2 != dx2*dy) return false;
            }
        }
        return true;
    }
}