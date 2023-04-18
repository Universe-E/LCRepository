import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class StreamChecker {
    HashMap<Integer,HashSet<String>> ss;
    char[] cs;
    int cnt;
    public StreamChecker(String[] words) {
        ss = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            HashSet<String> set = ss.getOrDefault(len,new HashSet<>());
            set.add(word);
            ss.put(len, set);
        }
        cs = new char[10];
        cnt = 0;
    }

    public boolean query(char letter) {
        if (cnt >= cs.length) resize();
        cs[cnt] = letter;
        for (Integer k : ss.keySet()) {
            if (k > cnt+1) continue;
            String s = new String(Arrays.copyOfRange(cs,cnt-k+1,cnt+1));
            HashSet<String> set = ss.get(k);
            if (set.contains(s)) {
                cnt++;
                return true;
            }
        }
        cnt++;
        return false;
    }

    private void resize() {
        char[] cs = new char[this.cs.length*2];
        System.arraycopy(this.cs, 0, cs, 0,this.cs.length);
        this.cs = cs;
    }
}
