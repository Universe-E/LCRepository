import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Solution {
    public String lastSubstring(String s) {
        //由于求s[i,j]的最大字典序，因此答案一定为某个后缀。j不可能提前终止
        //设start为起始位置，mx为最大序号(0-25)
        int n = s.length(), start = -1,mx = -1;
        for (int i = n-1; i >= 0; i--) {
            int cur = s.charAt(i) - 'a';
            //如果当前序号大于最大序号，则更新start和mx
            if (cur > mx) {
                start = i;
                mx = cur;
            }
            //如果cur等于mx，则要继续看后面的序号是否更大
            else if (cur == mx) {
                //如果s[i-1]与s[i]相同，则跳过比较，直到找到边界处s[i]满足cur==mx
                if (i > 0 && s.charAt(i-1) == s.charAt(i)) continue;
                //初始化是否要更新start
                boolean change = true;
                //分别从当前i和之前的start开始遍历，直至边界点为止
                //注意j只需要枚举到start-1，因为s[start,n-1]已经是目前最大后缀
                for (int j = i,k = start; j < start && k < n; j++,k++) {
                    //如果发现当前序号s[j]比s[k]小，则当前i不能更新
                    if (s.charAt(j) < s.charAt(k)) {
                        change = false;
                        break;
                    }
                    //如果找到s[j]比s[k]大，则提前终止
                    else if (s.charAt(j) > s.charAt(k)) break;
                }
                //如果全部遍历结束，依然可以更新，此时说明s[start,n-1]是s[i,n-1]的一个子串
                //例如"cbacba"，可以在i=0将原先的答案"cba"更新为"cbacba"
                if (change) start = i;
                //由于start不断向前更新，因此不会被重复遍历
                //例如：构造"babaabaaabaa...baa..aa(每一轮出现b，a都会多一个)"
            }
        }
        return s.substring(start);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\UE\\Desktop\\tc.txt");

        FileOutputStream fos = new FileOutputStream(file);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 199999; i++) {
            sb.append("b");
        }
        sb.append("a");
        for (int i = 0; i < 200000; i++) {
            sb.append("b");
        }
        String s = sb.toString();
        fos.write(s.getBytes());
        fos.close();
        new Solution().lastSubstring(sb.toString());
    }
}