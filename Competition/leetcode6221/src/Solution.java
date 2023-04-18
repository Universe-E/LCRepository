import java.util.*;

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
        HashMap<String,Long> viewMap = new HashMap<>();
        long max = 0;
        for (int i = 0; i < n; i++) {
            //put the index of ids,sorted by views descending
            PriorityQueue<Integer> pq;
            if (!map.containsKey(creators[i])) pq = new PriorityQueue<>((o1, o2) -> {
                if (views[o1] == views[o2]) return ids[o1].compareTo(ids[o2]);
                return views[o2] - views[o1];
            });
            else pq = map.get(creators[i]);
            pq.add(i);
            map.put(creators[i], pq);
            //store the total views of each creator
            viewMap.put(creators[i],viewMap.getOrDefault(creators[i],0L) + views[i]);
            //get the maximum views
            max = Math.max(max,viewMap.get(creators[i]));
        }
        List<List<String>> res = new ArrayList<>();
        for (String s : map.keySet()) {
            if (viewMap.get(s) == max) {
                List<String> list = new ArrayList<>();
                PriorityQueue<Integer> pq = map.get(s);
                String id = ids[pq.peek()];
                list.add(s);
                list.add(id);
                res.add(list);
            }
        }
        return res;
    }
}