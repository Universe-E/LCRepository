import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] ss1 = sentence1.split(" "), ss2 = sentence2.split(" ");
        ArrayDeque<String> dq1 = new ArrayDeque<>(Arrays.asList(ss1)),
                dq2 = new ArrayDeque<>(Arrays.asList(ss2));
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekFirst().equals(dq2.peekFirst())) {
            dq1.pollFirst();
            dq2.pollFirst();
        }
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }
        return dq1.isEmpty() || dq2.isEmpty();
    }
}

class Solution2 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] ss1 = sentence1.split(" "), ss2 = sentence2.split(" ");
        int n1 = ss1.length, n2 = ss2.length;
        int l1 = 0,r1 = n1-1, l2 = 0, r2 = n2-1;
        while (l1 < n1 && l2 < n2 && ss1[l1].equals(ss2[l2])) {
            l1++;
            l2++;
        }
        while (r1 >= l1 && r2 >= l2 && ss1[r1].equals(ss2[r2])) {
            r1--;
            r2--;
        }
        return l1==r1+1 || l2==r2+1;
    }
}