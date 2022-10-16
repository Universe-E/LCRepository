import java.util.HashMap;

public class Solution3 {
    public int beautifulBouquet(int[] flowers, int cnt) {
        int n = flowers.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        long res = 0;
        int M = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            map.put(flowers[i],map.getOrDefault(flowers[i],0) + 1);
            while (map.get(flowers[i]) > cnt) {
                map.put(flowers[left],map.get(flowers[left]) - 1);
                left++;
            }
            res += i - left + 1;
        }
        return  (int) (res % M);
    }
}
