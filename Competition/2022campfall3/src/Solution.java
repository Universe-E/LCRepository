import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int beautifulBouquet(int[] flowers, int cnt) {
        int n = flowers.length;
        //先获得相同花束的坐标
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list;
            if (!map.containsKey(flowers[i])) {
                list = new ArrayList<>();
            }
            else {
                list = map.get(flowers[i]);
            }
            list.add(i);
            map.put(flowers[i],list);
        }
        long res = (long) n * (long) (n + 1) / 2;
        int M = (int) (1e9 + 7);
        for (Integer flower : map.keySet()) {
            List<Integer> list = map.get(flower);
            if (list.size() > cnt) {
                //从每一个list.get(i)起始向左遍历，包含这一区间的子数组都要被排除，共计list.get(i) + 1组
                for (int i = 0; i < list.size() - cnt; i++) {
                    int groups = 1;
                    if (i == list.size() - cnt - 1) {
                        for (int j = list.get(i + cnt) + 1; j < n; j++) {
                            if (map.get(flowers[j]).size() <= cnt) groups++;
                        }
                    }
                    else {
                        for (int j = list.get(i + cnt) + 1; j < list.get(i + cnt + 1); j++) {
                            if (map.get(flowers[j]).size() <= cnt) groups++;
                        }
                    }
                    res -= (list.get(i) + 1) * groups;
                }
            }
        }
        return (int) (res % M);
    }

    public static void main(String[] args) {
        int[] flowers = new int[] {1,3,3,3,3,2};
        int cnt = 2;
        int res = new Solution().beautifulBouquet(flowers,cnt);
        System.out.println(res);
    }
}