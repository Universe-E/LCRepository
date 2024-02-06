import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> list;
            if (!map.containsKey(key)) list = new ArrayList<>();
            else list = map.get(key);
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            for (char c : str.toCharArray()) {
                cnt[c-'a']++;
            }
            int h = hash(cnt);
            map.computeIfAbsent(h,e->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private int hash(int[] cnt) {
        int m1 = 65537, m2 = (int) 1e9+7,res = 0;
        for (int i = 0; i < 26; i++) {
            res = (int) (((long)m1*res + cnt[i])%m2);
        }
        return res;
    }
}