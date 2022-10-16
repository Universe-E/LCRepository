import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i+1) == 'X')) res -= 1;
            else if (i < s.length() - 1 && s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) res -= 10;
            else if (i < s.length() - 1 && s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) res -= 100;
            else res += map.get(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new Solution().romanToInt(s));
    }
}
