import java.util.HashMap;

//滑动窗口
public class Solution3 {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i],map.getOrDefault(fruits[i],0) + 1);
            while (map.size() > 2) {
                map.put(fruits[l],map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }
            res = Math.max(res,i - l + 1);
        }
        return res;
    }
}
