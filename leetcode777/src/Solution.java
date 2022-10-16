import java.util.ArrayList;
import java.util.List;

class Solution {
    //第一：如果将start、end中的‘X’全部去掉得到的newStart 和 newEnd相等才有可能转换成功。
    //第二：如果start中'R'的左边'X'的个数超过在end中对应位置的'R'的左边'X'的个数，则不能转换成功，因为start中的'R'只能向右移动，右边的'X'只能增加不能减少
    //第三：如果start中'L'的左边'X'的个数小于end在中对应位置的'L'的左边'X'的个数，则不能转换成功，因为start中的'L'只能向左移动，左边的'X'只能减少不能增加
    public boolean canTransform(String start, String end) {
        StringBuilder s1 = new StringBuilder(),s2 = new StringBuilder();
        int n = start.length();
        int curX1 = 0,curX2 = 0;//记录当前经过的X个数
        List<Integer> startList = new ArrayList<>(),endList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = start.charAt(i);
            if (c == 'X') curX1++;
            else {
                s1.append(c);
                startList.add(curX1);
            }
            char c2 = end.charAt(i);
            if (c2 == 'X') curX2++;
            else {
                s2.append(c2);
                endList.add(curX2);
            }
        }
        if (!s1.toString().equals(s2.toString())) return false;
        String str = s1.toString();
        int n2 = s1.length();
        for (int i = 0; i < n2; i++) {
            int s = startList.get(i),e = endList.get(i);
            if (str.charAt(i) == 'R' && s > e) return false;
            if (str.charAt(i) == 'L' && s < e) return false;
        }
        return true;
    }
}