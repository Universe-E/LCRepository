import java.util.*;

class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    int[] peo;
    int all = 0;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Arrays.sort(req_skills);
        //考虑到最高只有16位，可以二进制处理，总共要求达到111...111(n个1)
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i],i);
            all += 1<<i;
        }
        int m = people.size();
        peo = new int[m];
        int idx = 0;
        for (List<String> p : people) {
            int cur = 0;
            for (String s : p) {
                int i = map.get(s);
                cur += 1<<i;
            }
            peo[idx++] = cur;
        }
        for (int i = 0; i < m; i++) {
            //找到和i技能重复的人，优化掉，标为-1
            for (int j = i+1; j < m; j++) {
                if ((peo[j] | peo[i]) == peo[j]) {
                    peo[i] = -1;
                    break;
                }
            }
        }

        backTrack(0,0,new ArrayList<>());
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void backTrack(int cur,int i,List<Integer> list) {
        if (cur == all) {
            if (res.isEmpty()) res = new ArrayList<>(list);
            else {
                if (res.size() > list.size()) res = new ArrayList<>(list);
            }
            return;
        }
        for (int j = i; j < peo.length; j++) {
            //跳过重复技能的人
            if (peo[j] == -1) continue;
            //跳过已经选过的结果
            if ((cur | peo[j]) == cur) continue;
            list.add(j);
            backTrack(cur | peo[j],j+1,list);
            list.remove(list.size()-1);
        }
    }
}