import java.util.ArrayList;

class Solution {
    public boolean areNumbersAscending(String s) {
        String[] ss = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s1 : ss) {
            if (check(s1)) list.add(Integer.parseInt(s1));
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1)) return false;
        }
        return true;
    }

    private boolean check(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }


}