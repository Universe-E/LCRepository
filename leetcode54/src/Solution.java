import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length,a = 0, b = 0;
        int[][] visited = new int[m][n];//用visited标记，1表示已访问，0表示未访问
        List<Integer> res = new ArrayList<>();
        String conditions = "right";
        while (res.size() < m * n) {
            switch (conditions) {
                case "right":
                    res.add(matrix[a][b]);
                    visited[a][b] = 1;
                    b++;
                    if (b == n || visited[a][b] != 0) {
                        conditions = "down";
                        a++;
                        b--;
                    }
                    break;
                case "down":
                    res.add(matrix[a][b]);
                    visited[a][b] = 1;
                    a++;
                    if (a == m || visited[a][b] != 0) {
                        conditions = "left";
                        b--;
                        a--;
                    }
                    break;
                case "left":
                    res.add(matrix[a][b]);
                    visited[a][b] = 1;
                    b--;
                    if (b == -1 || visited[a][b] != 0) {
                        conditions = "up";
                        a--;
                        b++;
                    }
                    break;
                default:
                    res.add(matrix[a][b]);
                    visited[a][b] = 1;
                    a--;
                    if (visited[a][b] != 0) {
                        conditions = "right";
                        b++;
                        a++;
                    }
                    break;
            }
            System.out.println(a + "," + b);
        }
        return res;
    }
}
