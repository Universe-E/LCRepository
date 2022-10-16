import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] temp = cpdomain.split(" ");
            //出现次数
            int times = Integer.parseInt(temp[0]);
            //域名解析
            String[] addr = temp[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = addr.length - 1; i >= 0; i--) {
                String curAddr = sb.insert(0,addr[i]).toString();
                map.put(curAddr, map.getOrDefault(curAddr,0) + times);
                sb.insert(0,'.');
            }
        }
        List<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            String input = map.get(s) + " " + s;
            res.add(input);
        }
        return res;
    }
}