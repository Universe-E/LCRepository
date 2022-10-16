import java.util.ArrayList;
import java.util.List;

class Solution {
    char[] number = {'1','2','3','4','5','6','7','8','9','0'};
    List<Character> list = new ArrayList<>();
    public Solution() {
        for (char c : number) list.add(c);
    }
    public int myAtoi(String s) {
        String strim = s.trim();
        if (strim.length() == 0) return 0;
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < strim.length(); i++) {
            if (list.contains(strim.charAt(i))) {
                if (res.size() == 0 && i > 1) return 0;
                //如果第一个数字的前一个是负号，则加到结果中去
                if (i != 0 && strim.charAt(i - 1) == '-') res.add(strim.charAt(i - 1));
                res.add(strim.charAt(i));
                if (i != strim.length() - 1 && !list.contains(strim.charAt(i + 1))) break;
            }
            else {
                if (!(strim.charAt(0) == '+' || strim.charAt(0) == '-')) return 0;
                else if (i > 1) return 0;
            }
        }
        if (res.size() == 0) return 0;
        //如果是负数
        StringBuilder sb = new StringBuilder();
        if (res.get(0) == '-') {
            int i = 1;
            while (res.get(i) == '0') i++;
            for (int j = i; j < res.size(); j++) sb.append(res.get(j) - '0');
            String abs = sb.toString();
            if (abs.length() > 10) return Integer.MIN_VALUE;
            //如果位数等于10，则用long进行比较
            if (abs.length() == 10) return Long.parseLong(abs) >= 2147483648L ? Integer.MIN_VALUE : -Integer.parseInt(abs);
            else return -Integer.parseInt(abs);
        }
        else {
            int i = 0;
            while (res.get(i) == '0') i++;
            for (int j = i; j < res.size(); j++) sb.append(res.get(j) - '0');
            String abs = sb.toString();
            if (abs.length() > 10) return Integer.MAX_VALUE;
            if (abs.length() >= 10) return Long.parseLong(abs) >= Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.parseInt(abs);
            else return Integer.parseInt(abs);
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().myAtoi("   -42"));
    }
}
