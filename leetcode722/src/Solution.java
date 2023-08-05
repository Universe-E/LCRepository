import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeComments(String[] source) {
        //line together and separate with "\n"
        StringBuilder sb = new StringBuilder(String.join("\n",source)).append("\n");
        int idxLine = -1,idxBlock = -1,i = 0,n = sb.length();
        while (i < n) {
            int j = sb.indexOf("/",i);
            if (j == -1) break;
            char c2 = sb.charAt(j+1);
            //line comments
            if (c2 == '/') {
                //index to the next "\n"
                sb.delete(j,sb.indexOf("\n",j+2));
                i = j;
            }
            //block comments
            else if (c2 == '*') {
                //index to the next "*/\n",delete includes "\n"
                sb.delete(j,sb.indexOf("*/",j+2)+2);
                i = j;
            }
            //other situation, no delete
            else i = j+2;
        }
        List<String> res = new ArrayList<>();
        for (String s : sb.toString().split("\n")) {
            if (!s.isEmpty()) res.add(s);
        }
        return res;
    }
}