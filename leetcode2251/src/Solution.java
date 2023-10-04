import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = persons.length;
        //离散化差分映射
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] flower : flowers) {
            map.put(flower[0], map.getOrDefault(flower[0],0) + 1);
            map.put(flower[1] + 1,map.getOrDefault(flower[1] + 1,0) - 1);
        }
        int[] times = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        //将persons的id按照到达时间排序
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(o -> persons[o]));
        int[] res = new int[n];
        int t = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            while (t < times.length && times[t] <= persons[idx[i]]) {
                //按照差分数组的定义，所有flower[0]处的点对应相加，flower[1]处的点对应相减
                //因此sum即为persons[idx[i]]时刻的人
                sum += map.get(times[t]);
                t++;
            }
            res[idx[i]] = sum;
        }
        return res;

    }
}