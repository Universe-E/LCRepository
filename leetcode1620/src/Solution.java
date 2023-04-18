import java.util.Arrays;

class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        //find the bound of the rectangle
        int n = towers.length;
        //sort by x ascend, if x's are the same, sort by y ascend
        Arrays.sort(towers,(o1,o2) -> (o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]));
        //then enumerate
        int sum = -1,x = -1,y = -1;
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int cur = getSignal(towers,i,j,radius);
                if (cur > sum) {
                    x = i;
                    y = j;
                    sum = cur;
                }
            }
        }
        return new int[] {x,y};
    }

    private int getSignal(int[][] towers,int i,int j,int radius) {
        int sum = 0;
        for (int[] tower : towers) {
            double d = Math.sqrt(Math.pow(tower[0]-i,2)+Math.pow(tower[1]-j,2));
            if (d <= radius) sum += tower[2]/(1+d);
        }
        return sum;
    }
}