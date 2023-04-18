import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int n = searchWord.length();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String pre = searchWord.substring(0,i+1);
            int l = 0, r = products.length;
            //字符串排序+二分查找首个以pre开头的单词
            while (l < r) {
                int mid = (l + r) / 2;
                //注意边界
                String curPre = products[mid].substring(0,Math.min(i+1,products[mid].length()));
                if (curPre.compareTo(pre) < 0) l = mid + 1;
                else r = mid;
            }
            List<String> curList = new ArrayList<>();
            //将符合条件的单词加入list
            for (int j = l; j < Math.min(products.length,l+3); j++) {
                //如果不符合条件，直接break即可，后面的一定也不符合条件
                if (!products[j].startsWith(pre)) break;
                curList.add(products[j]);
            }
            list.add(curList);
        }
        return list;
    }
}