import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        PriorityQueue<Pair<String,Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) return o1.getKey().compareTo(o2.getKey());
            return o2.getValue().compareTo(o1.getValue());
        });
        for (String s : map.keySet()) {
            pq.add(new Pair<>(s,map.get(s)));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
}