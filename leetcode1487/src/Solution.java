import java.util.HashMap;

class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) map.put(names[i],1);
            else {
                int k = map.get(names[i]);
                //得到已有的出现次数
                while (map.containsKey(names[i] + "(" + k+")")) {
                    map.put(names[i],++k);
                }
                map.put(names[i], k+1);
                names[i] += "(" + k+")";
                map.put(names[i],map.getOrDefault(names[i],0)+1);
            }
        }
        return names;
    }
}
