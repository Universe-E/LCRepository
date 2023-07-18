import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    //0N1E2S3W
    int d = 0,x=0,y=0;

    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer, TreeSet<Integer>> col = new HashMap<>(),row = new HashMap<>();
        for (int[] o : obstacles) {
            col.computeIfAbsent(o[1],k -> new TreeSet<>()).add(o[0]);
            row.computeIfAbsent(o[0],k -> new TreeSet<>()).add(o[1]);
        }
        int res = 0;
        for (int command : commands) {
            //turn
            if (command == -2 || command == -1) d = command==-2 ? ((d-1+4)%4) : ((d+1)%4);
            //move
            else {
                if (d == 0 || d == 2) {
                    int des = (d==0) ? (y+command) : (y-command);
                    if (row.get(x) == null) y = des;
                    else {
                        Integer nearest = (d==0) ? row.get(x).higher(y) : row.get(x).lower(y);
                        if (d == 0) {
                            if (nearest != null && nearest <= des) y = nearest-1;
                            else y += command;
                        }
                        else {
                            if (nearest != null && nearest >= des) y = nearest+1;
                            else y -= command;
                        }
                    }
                }
                else {
                    int des = (d==1) ? (x+command) : (x-command);
                    if (col.get(y) == null) x = des;
                    else {
                        Integer nearest = (d==1) ? col.get(y).higher(x) : col.get(y).lower(x);
                        if (d == 1) {
                            if (nearest != null && nearest <= des) x = nearest-1;
                            else x += command;
                        }
                        else {
                            if (nearest != null && nearest >= des) x = nearest+1;
                            else x -= command;
                        }
                    }
                }
                res = Math.max(res,x*x+y*y);
            }
        }
        return res;
    }
}