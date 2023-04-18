class Solution {
    int x = 0,y = 0,d = 1;
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
        for (int i = 0; i < n; i++) {
            char c = instructions.charAt(i);
            if (c == 'G') move();
            else d = getDirection(c);
        }
        //判断最终位置，如果依然在原点，返回true
        if (x == 0 && y == 0) return true;
        //如果不在原点，则判断方向，只要方向不是初始方向（北）就代表一定存在循环
        return d != 1;
    }

    //1234分别代表北东南西
    private int getDirection(char c) {
        if (d == 1) return c == 'R' ? 2 : 0;
        else if (d == 2) return c == 'R' ? 3 : 1;
        else if (d == 3) return c == 'R' ? 4 : 2;
        return c == 'R' ? 1 : 3;
    }

    private void move() {
        if (d == 1) y++;
        else if (d == 2) x++;
        else if (d == 3) y--;
        else x--;
    }
}