class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 1,a = 0,b = 0;
        String conditions = "right";
        while (i <= Math.pow(n,2)) {
            switch (conditions) {
                case "right":
                    res[a][b] = i;
                    b++;
                    if (b == n || res[a][b] != 0) {
                        conditions = "down";
                        a++;
                        b--;
                    }
                    break;
                case "down":
                    res[a][b] = i;
                    a++;
                    if (a == n || res[a][b] != 0) {
                        conditions = "left";
                        b--;
                        a--;
                    }
                    break;
                case "left":
                    res[a][b] = i;
                    b--;
                    if (b == -1 || res[a][b] != 0) {
                        conditions = "up";
                        a--;
                        b++;
                    }
                    break;
                default:
                    res[a][b] = i;
                    a--;
                    if (res[a][b] != 0) {
                        conditions = "right";
                        b++;
                        a++;
                    }
                    break;
            }
            i++;
        }
        return res;
    }
}