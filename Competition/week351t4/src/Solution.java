import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = positions[i];
            arr[i][2] = healths[i];
            arr[i][3] = directions.charAt(i)=='L' ? 0 : 1;
        }
        //按位置排序
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        var q = new ArrayDeque<int[]>();
        for (int i = 0; i < n; i++) {
            boolean add = true;
            //如果放入的方向向左，考察和向右的机器人碰撞
            if (arr[i][3] == 0) {
                //单调栈
                while (!q.isEmpty() && q.peekLast()[3] == 1) {
                    int peekHealth = q.peekLast()[2];
                    //全部碰坏
                    if (peekHealth == arr[i][2]) {
                        q.pollLast();
                        add = false;
                        break;
                    }
                    //碰坏待加入的
                    else if (peekHealth > arr[i][2]) {
                        int[] p = q.pollLast();
                        p[2]--;
                        q.addLast(p);
                        add = false;
                        break;
                    }
                    //碰坏栈内的
                    else {
                        q.pollLast();
                        arr[i][2]--;
                    }
                }
            }
            if (add) q.addLast(arr[i]);
        }
        int sz = q.size();
        if (sz == 0) return new ArrayList<>();
        Integer[][] res = new Integer[sz][2];
        for (int i = 0; i < sz; i++) {
            int[] c = q.pollFirst();
            assert c != null;
            res[i][0] = c[0];
            res[i][1] = c[2];
        }
        Arrays.sort(res,Comparator.comparingInt(o -> o[0]));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < sz; i++) {
            list.add(res[i][1]);
        }
        return list;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx,Comparator.comparingInt(o -> positions[o]));
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (directions.charAt(idx[i]) == 'L') {
                while (!q.isEmpty() && directions.charAt(q.peekLast()) == 'R') {
                    int peekHealth = healths[q.peekLast()];
                    //全部碰坏
                    if (peekHealth == healths[idx[i]]) {
                        healths[idx[i]] = healths[q.pollLast()] = 0;
                        break;
                    }
                    //碰坏待加入的
                    else if (peekHealth > healths[idx[i]]) {
                        healths[q.peekLast()]--;
                        healths[idx[i]] = 0;
                        break;
                    }
                    //碰坏栈内的
                    else {
                        healths[q.pollLast()] = 0;
                        healths[idx[i]]--;
                    }
                }
            }
            if (healths[idx[i]] != 0) q.addLast(idx[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) list.add(healths[i]);
        }
        return list;
    }
}