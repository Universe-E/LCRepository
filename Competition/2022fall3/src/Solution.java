import java.util.ArrayList;
import java.util.List;

class Solution {
    List<int[]> res = new ArrayList<int[]>();
    public int[][] ballGame(int num, String[] plate) {
        int m = plate.length, n = plate[0].length();
        char[][] table = new char[m][n];
        for (int i = 0; i < m; i++) {
            table[i] = plate[i].toCharArray();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (table[i][j] == 'O') dfs(table,i,j,0,m,n,num,true);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    //回溯路径，i,j表示起始坐标，condition表示移动方向（0上1左2下3右）
    private void dfs(char[][] table, int i, int j, int condition, int m, int n, int num, boolean start) {
        if (num < 0 || i < 0 || i >= m || j < 0 || j >= n) return;
        //如果回溯路径在非起始点遇到洞口，则该次结果不可靠
        if (!start && table[i][j] == 'O') return;
        if ((i == 0  && condition == 0) || (i == m - 1 && condition == 2)) {
            if (j != 0 && j != n - 1 && table[i][j] == '.') res.add(new int[] {i,j});
        }
        if ((j == 0 && condition == 1) || (j == n - 1 && condition == 3)) {
            if (i != 0 && i != m - 1 && table[i][j] == '.') res.add(new int[] {i,j});
        }
        //开局在洞口的四种情况
        if (start) {
            start = false;
            dfs(table,i - 1,j,0,m,n,num - 1,start);
            dfs(table,i,j - 1,1,m,n,num - 1,start);
            dfs(table,i + 1,j,2, m, n,num - 1,start);
            dfs(table, i, j + 1, 3, m, n, num - 1, start);
        }
        //一般情况
        else {
            if (condition == 0) {
                if (table[i][j] == 'E') dfs(table,i,j-1,1,m,n,num-1,start);
                else if (table[i][j] == 'W') dfs(table,i,j+1,3,m,n,num-1,start);
                else dfs(table,i-1,j,0,m,n,num-1,start);
            }
            else if (condition == 1) {
                if (table[i][j] == 'E') dfs(table,i+1,j,2,m,n,num-1,start);
                else if (table[i][j] == 'W') dfs(table,i-1,j,0,m,n,num-1,start);
                else dfs(table,i,j-1,1,m,n,num-1,start);
            }
            else if (condition == 2) {
                if (table[i][j] == 'E') dfs(table,i,j+1,3,m,n,num-1,start);
                else if (table[i][j] == 'W') dfs(table,i,j-1,1,m,n,num-1,start);
                else dfs(table,i+1,j,2,m,n,num-1,start);
            }
            else {
                if (table[i][j] == 'E') dfs(table,i-1,j,0,m,n,num-1,start);
                else if (table[i][j] == 'W') dfs(table,i+1,j,2,m,n,num-1,start);
                else dfs(table,i,j+1,3,m,n,num-1,start);
            }
        }
    }
}