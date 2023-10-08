import java.util.HashMap;
import java.util.TreeMap;

class StockPrice {

    //维护time和price的关系，其中key为time，val为price
    HashMap<Integer,Integer> map;
    //维护每个price出现次数，其中key为price,val为每个price出现次数
    TreeMap<Integer,Integer> cnt;
    //维护最新时间
    int curTime;
    public StockPrice() {
        map = new HashMap<>();
        cnt = new TreeMap<>();
        curTime = 0;
    }

    public void update(int timestamp, int price) {
        //如果当前已经包含timestamp，则一定要从price出现次数中将其移除
        if (map.containsKey(timestamp)) {
            int v = map.get(timestamp);
            if (cnt.put(v,cnt.get(v)-1) == 1) cnt.remove(v);
        }
        //更新timestamp，同时更新price出现次数以及当前时间
        map.put(timestamp, price);
        cnt.put(price,cnt.getOrDefault(price,0)+1);
        curTime = Math.max(curTime,timestamp);
    }

    //从map中拿到最近时间的value即可
    public int current() {
        return map.get(curTime);
    }

    public int maximum() {
        return cnt.lastKey();
    }

    public int minimum() {
        return cnt.firstKey();
    }
}