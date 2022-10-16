import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String robotWithString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] cnt = new int[26];
        int minRemains = 0;
        //记录出现次数
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for (char c : cs) cnt[c - 'a']++;
        for (int i = 0; i < n; i++) {
            cnt[cs[i] - 'a']--;
            //找到后续最小的字母，即第一个非零字母
            while (minRemains != 25 && cnt[minRemains] == 0) minRemains++;
            stack.push(cs[i]);
            //如果当前的字母比后面最小的还要小，则将前面的全部取出
            while (!stack.isEmpty() && stack.peek() - 'a' <= minRemains) res.append(stack.pop());
        }
        return res.toString();
    }
}