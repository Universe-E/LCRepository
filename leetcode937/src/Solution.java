import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] ss1 = o1.split(" ");
            String[] ss2 = o2.split(" ");
            if (Character.isLetter(ss1[1].charAt(0)) && Character.isDigit(ss2[1].charAt(0))) return -1;
            else if (Character.isDigit(ss1[1].charAt(0)) && Character.isLetter(ss2[1].charAt(0))) return 1;
            else if (Character.isLetter(ss1[1].charAt(0)) && Character.isLetter(ss2[1].charAt(0))) {
                int i = 1;
                while (i < Math.min(ss1.length,ss2.length)) {
                    if (ss1[i].compareTo(ss2[i]) < 0) return -1;
                    else if (ss1[i].compareTo(ss2[i]) > 0) return 1;
                    else i++;
                }
                if (i == ss1.length && i == ss2.length) return ss1[0].compareTo(ss2[0]);
                else {
                    if (ss1.length > i) return 1;
                    else return -1;
                }
            }
            else return 0;
        });
        return logs;
    }
}