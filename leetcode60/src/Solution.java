import java.util.LinkedList;

class Solution {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        //先将数字按顺序放入表中
        for (int i = 1; i <= n; i++) list.add(i);
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            //cur为当前位置所在索引，即为k与(n - 1)!的商，注意如果能整除则需要将cur - 1
            int cur = k / factorial(n - 1);
            if (k % factorial(n - 1) == 0 && cur > 0) cur--;
            //在这里，移出对应索引的数字，其余顺序不变
            sb.append(list.remove(cur));
            //接下来只需要维护后续的排列结果：减去相应索引的排列数，减去后的结果k用于后续的排列
            k -= cur * factorial(n - 1);
            n--;
        }
        return sb.toString();
    }

    private int factorial(int n) {
        if (n == 0) return 1;
        int res = 1;
        for (int i = 1; i <= n; i++) res *= i;
        return res;
    }
}
