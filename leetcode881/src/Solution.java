import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int p : people) {
            map.put(p,map.getOrDefault(p,0)+1);
        }
        int l = 0, r = people.length;
        while (l < r) {
            int m = (l+r)/2;
            //如果当前数量满足条件，则让r = m
            if (check(new TreeMap<>(map),m,limit)) r = m;
            else l = m+1;
        }
        return l;
    }

    //判断m艘船是否满足
    private boolean check(TreeMap<Integer,Integer> map, int m, int limit) {
        int cnt = 0,cur = limit;
        while (!map.isEmpty()) {
            int member = 0;
            //每次都装能装下的最重的人，直到装满2人为止
            while (map.floorKey(cur) != null && member < 2) {
                Integer k = map.floorKey(cur);
                cur -= k;
                map.put(k,map.get(k)-1);
                if (map.get(k) == 0) map.remove(k);
                member++;
            }
            //这艘船开走，下一艘船上
            cnt++;
            cur = limit;
        }
        return cnt <= m;
    }
}

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                ++l;
            }
            --r;
            ++res;
        }
        return res;
    }
}
