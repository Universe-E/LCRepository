import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        int length = (int) Math.pow(2,n);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        return code(n,list);
    }

    private List<Integer> code(int n,List<Integer> list) {
        int size = list.size();
        if (size == 1 << n) return list;
        for (int i = size - 1; i >= 0; i--) {
            list.add(list.get(i) + size);
        }
        return code(n,list);
    }
}