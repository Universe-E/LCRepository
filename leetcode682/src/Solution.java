import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int calPoints(String[] ops) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (String op : ops) {
            if (Character.isDigit(op.charAt(0))) {
                int value = Integer.parseInt(op);
                res += value;
                list.add(value);
            } else if (op.charAt(0) == '-') {
                int value = -Integer.parseInt(op.substring(1));
                res += value;
                list.add(value);
            } else if (op.charAt(0) == '+') {
                int prior1 = list.get(list.size() - 1);
                int prior2 = list.get(list.size() - 2);
                res += prior1 + prior2;
                list.add(prior1 + prior2);
            } else if (op.charAt(0) == 'C') {
                res -= list.get(list.size() - 1);
                list.remove(list.size() - 1);
            } else if (op.charAt(0) == 'D') {
                int value = 2 * list.get(list.size() - 1);
                res += value;
                list.add(value);
            }
        }
        return res;
    }
}
