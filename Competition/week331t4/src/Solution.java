import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = basket1.length;
        int min = 0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            map.merge(basket1[i],1, Integer::sum);
            map.merge(basket2[i],-1,Integer::sum);
            min = Math.min(min,Math.min(basket1[i],basket2[i]));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int k = e.getKey(), v = e.getValue();
            //必须是2的倍数，否则无法交换
            if (v % 2 != 0) return -1;
            //添加待交换的元素
            for (int i = Math.abs(v)/2; i > 0; i--) {
                list.add(k);
            }
        }
        long res = 0;
        //拿最小和最大交换，因此只要计算前一半元素即可
        Collections.sort(list);
        for (int i = 0; i < list.size() / 2; i++) {
            //如果选择第三方元素min，则每次交换需要两次（一来一回）
            res += Math.min(list.get(i),min*2);
        }
        return res;
    }
}