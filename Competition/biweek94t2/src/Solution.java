import java.util.*;

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int n = student_id.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[0]==o2[0] ? student_id[o1[1]]-student_id[o2[1]] : o2[0]-o1[0]);
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<String> pSet = new HashSet<>(Arrays.asList(positive_feedback)), nSet = new HashSet<>(Arrays.asList(negative_feedback));
        for (int i = 0; i < n; i++) {
            String[] ss = report[i].split(" ");
            int score = 0;
            for (String s : ss) {
                if (pSet.contains(s)) score += 3;
                if (nSet.contains(s)) score -= 1;
            }
            pq.add(new int[] {score,i});
        }
        while (k > 0) {
            res.add(student_id[(int) pq.poll()[1]]);
            k--;
        }
        return res;
    }
}