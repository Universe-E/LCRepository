import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        //分别统计右括号和左括号所在索引
        //从左到右遍历，找到“冗余”的括号
        for (int i = 0; i < n; i++) {
            //-1表示左括号，1表示右括号，第二位表示索引
            if (cs[i] == '(') {
                deque.push(new int[] {-1,i});
            }
            if (cs[i] == ')') {
                if (!deque.isEmpty() && deque.peek()[0] == -1) deque.pop();//匹配成功
                else deque.push(new int[] {1,i});//无匹配
            }
        }
        if (deque.isEmpty()) {
            res.add(s);
            return res;
        }
        //统计数量，后续问题转化为求删除r个右括号+l个左括号的所有组合
        int r = 0,l = 0;
        while (!deque.isEmpty()) {
            int[] cur = deque.pop();
            if (cur[0] == 1) r++;
            else l++;
        }
        //只存储符合要求的索引
        System.out.println(r + "," + l);
        backTrack(r,l,0,s);
        return res;
    }


    private void backTrack(int r,int l,int start,String s) {
        if (r == 0 && l == 0) {
            if (isValid(s)) res.add(s);
            return;
        }
        //逐个删除比较
        for (int i = start; i < s.length(); i++) {
            //去重
            if (i != start && s.charAt(i) == s.charAt(i-1)) continue;
            //剩下的长度得足够长
            if (r + l > s.length() - i) return;
            //记住这种删除技巧
            String ds = s.substring(0,i) + s.substring(i+1);
            //这里的start = i就是删除后的下一个索引
            if (s.charAt(i) == '(') backTrack(r,l-1,i,ds);
            if (s.charAt(i) == ')')  backTrack(r-1,l,i,ds);
        }
    }

    //判断是否为有效括号
    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            if (s.charAt(i) == ')') {
                if (cnt == 0) return false;
                cnt--;
            }
        }
        return cnt == 0;
    }
}