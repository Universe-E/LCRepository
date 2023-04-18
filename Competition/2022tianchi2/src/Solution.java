class Solution {
    int x = 0,y = 0;
    final int[] d = new int[] {0,1,2,3};//0,1,2,3分别代表下，右，上，左
    public int getLength(String[] grid) {
        int res = 0;
        int m = grid.length,n = grid[0].length();
        char[][] cs = new char[m][n];
        for (int i = 0; i < m; i++) {
            cs[i] = grid[i].toCharArray();
        }
        int direction = 0;
        while (inArea(x,y,m,n)) {
            direction = logic(direction,cs[x][y]);
            move(direction);
            res++;
        }
        return res;
    }

    private boolean inArea(int i,int j,int m,int n) {
        return i>=0 && i < m && j >= 0 && j < n;
    }

    private void move(int direction) {
        if (direction == 0) x++;
        else if (direction == 1) y++;
        else if (direction == 2) x--;
        else if (direction == 3) y--;
    }

    private int logic(int direction, char c) {
        if (c == 'L') {
            if (direction == 0) return 1;
            else if (direction == 1) return 0;
            else if (direction == 2) return 3;
            else if (direction == 3) return 2;
        }
        else if (c == 'R') {
            if (direction == 0) return 3;
            else if (direction == 1) return 2;
            else if (direction == 2) return 1;
            else if (direction == 3) return 0;
        }
        return direction;
    }
}