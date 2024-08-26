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


class Solution {
    public int calPoints(String[] ops) {
        int res = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (String op : ops) {
            switch (op) {
                case "D" -> {
                    int top = q.peekLast();
                    q.addLast(2 * top);
                }
                case "C" -> q.pollLast();
                case "+" -> {
                    int temp = q.peekLast();
                    q.pollLast();
                    int temp2 = q.peekLast();
                    q.addLast(temp);
                    q.addLast(temp + temp2);
                }
                default -> q.addLast(Integer.valueOf(op));
            }
        }
        while (!q.isEmpty()) {
            res += q.pollLast();
        }
        return res;
    }
}
